package com.qlu.rjq.pc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 　* @author ruanjq
 * <p>
 * 　* @date 2021/7/2710:18
 * <p>
 * 　* @version 1.0
 * <p>
 *
 **/
//多线程 juc lock 消费者生产者

public class pc {
    public static void main(String[] args) {
        final Provider provider = new Provider();
        new Thread(()->{
            for (int i=0;i<60;i++){
                provider.sell();

            }
        },"A").start();
        new Thread(()->{
            for (int i=0;i<60;i++){
                provider.sell();

            }
        },"B").start();
        new Thread(()->{
            for (int i=0;i<60;i++){
                provider.sell();
            }
        },"C").start();
    }


}

class Provider{
    private int num = 60;
    public synchronized void  sell(){
        while (num>0){
            System.out.println(Thread.currentThread().getName()+"出售了第"+num+"张票，还剩余"+(--num));

        }
    }
}
