package com.qlu.rjq.dome1;


import java.util.concurrent.CountDownLatch;

/**
 * 　* @author ruanjq
 * <p>
 * 　* @date 2021/8/1610:37
 * <p>
 * 　* @version 1.0
 * <p>
 *
 **/
public class CountDownLatchDome {
    public static void main(String[] args) throws InterruptedException {
        //计数器 记录线程 必须有7个线程执行完才关闭 减法计数器
        CountDownLatch countDownLatch = new CountDownLatch(7);
        for (int i = 0; i < 6; i++) { //不到的话回一直阻塞
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+countDownLatch.getCount());
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();


    }
}
