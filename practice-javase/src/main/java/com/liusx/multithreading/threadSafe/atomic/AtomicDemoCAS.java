package com.liusx.multithreading.threadSafe.atomic;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * description: AtomicDemoCAS 利用CAS实现原子性操作 <br>
 * date: 2020/7/18 14:11 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 */
public class AtomicDemoCAS {
    volatile int value = 0;

    static Unsafe unsafe;//直接操作内存，通过内存中针对对象的属性的偏移量来修改对象的属性值
    private static long valueOffset;

    static{
        try {
            //通过反射获取unsafe值
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            //获取value属性偏移量（用于定位value属性在内存中的具体位置）
            valueOffset = unsafe.objectFieldOffset(AtomicDemoCAS.class.getDeclaredField("value"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void add(){
//        value++; 需要重点修改的地方，采用CAS机制来实现原子操作
        //记录本次操作中读取到的内存中的值
        int current;
        do {
            //直接通过偏移量去读取内存中的属性值。如果下面的操作执行失败了，说明内存中的值已经被其他线程更新，就重新通过偏移量获取一遍
            current = unsafe.getIntVolatile(this,valueOffset);
        }while(!unsafe.compareAndSwapInt(this,valueOffset,current,current+1));//可能会失败，失败返回的false
        //compareAndSwapInt()方法中:
        // 第一个属性指的是这个操作的属性属于哪个对象，因为是本对象所以是this
        // 第二个属性指的是偏移量
        // 第三个属性指的是当前内存中的值（会拿着这个去和最新的值比较）
        // 第四个属性指的是本次要赋值给属性的值
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicDemoCAS ad = new AtomicDemoCAS();
        for (int i = 0; i < 2; i++){
            new Thread( () ->{
                for (int j = 0; j < 10000; j++) {
                    ad.add();
                }
            }).start();
        }
        Thread.sleep(200L);
        System.out.println(ad.value);
    }
}
