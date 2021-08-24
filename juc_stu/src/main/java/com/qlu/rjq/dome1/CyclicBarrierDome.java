package com.qlu.rjq.dome1;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author ruanjq
 * @version 1.0
 * @date 2021/8/1714:12
 **/
public class CyclicBarrierDome {
    public static void main(String[] args) {
        //加法技术器
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7);
        for (int i = 0; i < 7; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName());
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
