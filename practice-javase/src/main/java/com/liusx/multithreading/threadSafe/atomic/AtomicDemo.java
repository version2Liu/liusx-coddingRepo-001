package com.liusx.multithreading.threadSafe.atomic;

/**
 * description: AtomicDemo 原子性操作属性探究示例 <br>
 * date: 2020/7/18 14:11 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 */
public class AtomicDemo {
    volatile int i = 0;
    public void add(){
        i++;
    }

    public static void main(String[] args) throws InterruptedException {
        AtomicDemo ad = new AtomicDemo();
        for (int i = 0; i < 2; i++){
            new Thread( () ->{
                for (int j = 0; j < 10000; j++) {
                    ad.add();
                }
            }).start();
        }
        Thread.sleep(200L);
        System.out.println(ad.i);
    }
}
