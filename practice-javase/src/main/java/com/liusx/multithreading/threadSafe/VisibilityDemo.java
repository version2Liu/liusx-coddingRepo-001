package com.liusx.multithreading.threadSafe;

import java.util.concurrent.TimeUnit;

/**
 * description: VisibilityDemo <br>
 * date: 2020/6/27 16:57 <br>
 * author: liusx <br>
 * version: 1.0 <br>
 */
public class VisibilityDemo {
    private boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        VisibilityDemo demo = new VisibilityDemo();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(demo.flag){
                    i++;
                }
                System.out.println(i);
            }
        });
        thread1.start();
        TimeUnit.SECONDS.sleep(2);
        demo.flag = false;
        System.out.println("被设置为false了");
    }
}
