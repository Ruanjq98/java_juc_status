package com.qlu.rjq.pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 　* @author ruanjq
 * <p>
 * 　* @date 2021/7/2714:53
 * <p>
 * 　* @version 1.0
 * <p>
 *
 **/
/*
JUC 版本
线程之间的通信问题：生产者消费者！ 等待唤醒，通知唤醒
        * 线程交替执行 A B 同时操作一个变量 num =0
        * A num+=1
        * B num-=1
        * */
public class JucPc {
    public static void main(String[] args) {
        JucProvider juc = new JucProvider();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                juc.incre();

            }
        },"A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                juc.incre();

            }
        },"B").start();


        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                juc.decre();

            }
        },"C").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                juc.decre();

            }
        },"D").start();

    }
}
class JucProvider{
    int i =0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void incre(){
        lock.lock();
        try {
            while (i != 0){
                condition.await();
            }
            i++;
            System.out.println(Thread.currentThread().getName()+"===========>"+i);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();

        }
    }
    public void decre(){
        lock.lock();
        try {
            while (i == 0){
                condition.await();
            }
            i--;
            System.out.println(Thread.currentThread().getName()+"===========>"+i);

            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}