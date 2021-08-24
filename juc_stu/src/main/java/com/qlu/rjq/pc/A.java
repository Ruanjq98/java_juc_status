package com.qlu.rjq.pc;

/**
 * 　* @author ruanjq
 * <p>
 * 　* @date 2021/7/2714:07
 * <p>
 * 　* @version 1.0
 * <p>
 *
 **/
/*
* 线程之间的通信问题：生产者消费者！ 等待唤醒，通知唤醒
* 线程交替执行 A B 同时操作一个变量 num =0
* A num+=1
* B num-=1
* */
public class A {
    public static void main(String[] args) {
        Data data = new Data();


        new Thread(()->{
            for (int i=0;i<10;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"A").start();

        new Thread(()->{
            for (int i=0;i<10;i++){
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"C").start();
        new Thread(()->{
            for (int j=0;j<10;j++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int j=0;j<10;j++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
//等待  业务  通知
/*
* 判断是否需要等待
*
* */
class Data{
    int num =0;
    public synchronized   void increment() throws InterruptedException {
        System.out.println("进入线程"+ Thread.currentThread().getName());
        while (num!=0){
            System.out.println("进入线程"+Thread.currentThread().getName()+"当前num不为0进行等待");
            System.out.println("释放"+Thread.currentThread().getName()+"锁");

            this.wait();
            System.out.println("进入线程"+Thread.currentThread().getName()+"释放锁");
        }
        System.out.println("线程"+ Thread.currentThread().getName()+"被唤醒   "+num);
        num++;
        System.out.println(Thread.currentThread().getName()+"++++++++>"+num);
        this.notify();
    }
    public synchronized   void decrement() throws InterruptedException {
        System.out.println("进入线程"+ Thread.currentThread().getName());
        while (num==0){
            System.out.println("进入线程"+Thread.currentThread().getName()+"当前num为0进行等待");
            System.out.println("释放"+Thread.currentThread().getName()+"锁");

            this.wait();
            System.out.println("线程"+Thread.currentThread().getName()+"被唤醒");
        }
        num--;
        System.out.println("线程"+ Thread.currentThread().getName()+"被唤醒   "+num);
        System.out.println(Thread.currentThread().getName()+"++++++++>"+num);
        this.notify();
    }
}