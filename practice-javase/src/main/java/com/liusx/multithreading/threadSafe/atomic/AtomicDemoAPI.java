package com.liusx.multithreading.threadSafe.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * description: AtomicDemoAPI 通过J.U.C并发包下面的api来实现原子操作 <br>
 * date: 2020/7/18 15:14 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 */
public class AtomicDemoAPI {
    AtomicInteger i = new AtomicInteger(0);

    public void add(){
        i.incrementAndGet();//i++操作
//        i.decrementAndGet();//i--操作
    }
    public static void main(String[] args) throws InterruptedException {
        AtomicDemoAPI ad = new AtomicDemoAPI();
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
