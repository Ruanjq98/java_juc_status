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

public class SellTicke {
    public static void main(String[] args) {
        Ticke ticke = new Ticke();
        new Thread(()->{
            for (int i=0;i<1000;i++){
            ticke.sell();}

        },"A").start();
        new Thread(()->{
            for (int i=0;i<1000;i++){
                ticke.sell();
            }

        },"B").start();
        new Thread(()->{
            for (int i=0;i<1000;i++){
                ticke.sell();
            }

        },"C").start();
        new Thread(()->{
            for (int i=0;i<1000;i++){
                ticke.sell();
            }

        },"D").start();
    }


}

class Ticke{
    private int num = 1000;
    Lock lock = new ReentrantLock(false);
    public  void  sell(){

        lock.lock();
        try {
            if (num>0){
                System.out.println(Thread.currentThread().getName()+"出售了第"+num+"张票，还剩余"+(--num));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
