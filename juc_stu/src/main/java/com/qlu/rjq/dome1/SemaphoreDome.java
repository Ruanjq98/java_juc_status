package com.qlu.rjq.dome1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author ruanjq
 * @version 1.0
 * @date 2021/8/1714:23
 **/
public class SemaphoreDome {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4); //信号标   停车场里面自有4个空位 最多4个一起执行

        for (int i = 1; i < 10; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();  //强到 线程 从这个方法开始抢夺 信号表  信号标 -1
                    System.out.println(Thread.currentThread().getName()+"抢到了停车位");
                    TimeUnit.SECONDS.sleep(50);
                    System.out.println(Thread.currentThread().getName()+"把车驶离了停车场");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },String.valueOf(i)).start();
        }
    }
}
