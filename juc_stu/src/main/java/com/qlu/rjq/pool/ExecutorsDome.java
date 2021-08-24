package com.qlu.rjq.pool;

import java.util.concurrent.*;

/**
 * @author ruanjq
 * @version 1.0
 * @date 2021/8/1716:08
 **/
public class ExecutorsDome {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();//单线程
        ExecutorService executorService1 = Executors.newFixedThreadPool(3);//固定线程池
        ExecutorService executorService2 = Executors.newCachedThreadPool();//可伸缩 的线程池

        Runtime.getRuntime().availableProcessors();//或去电脑几个核心
        //线程池七大参数
         /*
         * 1.核心线程数   (线程池创建出来的线程数大小)
         * 2.最大线程数   (线程过多的时候最大可以同时的开启的线程数)
         * 3.超时时间      (当多开出来的线程(5-2) 空闲多久后释放资源)
         * 4. 时间单位
         * 5.阻塞队列  (最多可以有多少个队列在等 (如下 最多可以有3个线程在等 当大于3个的时候开启新的队列 直到到达最大线程数)   )
         * 6.线程工厂 可用默认的
         * 7.拒绝策略 (4种) AbortPolicy()   默认拒绝策略(线程满了 阻塞队列也满了 就报错) CallerRunsPolicy() DiscardOldestPolicy() DiscardPolicy()
         * */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

        //线程池七大参数
        /*
         * 1.核心线程数   (线程池创建出来的线程数大小)
         * 2.最大线程数   (线程过多的时候最大可以同时的开启的线程数)
         * 3.超时时间      (当多开出来的线程(5-2) 空闲多久后释放资源)
         * 4. 时间单位
         * 5.阻塞队列  (最多可以有多少个队列在等 (如下 最多可以有3个线程在等 当大于3个的时候开启新的队列 直到到达最大线程数)   )
         * 6.线程工厂 可用默认的
         * 7.拒绝策略 (4种) CallerRunsPolicy() 多出来的由主线程执行  DiscardOldestPolicy() DiscardPolicy()
         * */
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

        //线程池七大参数
        /*
         * 1.核心线程数   (线程池创建出来的线程数大小)
         * 2.最大线程数   (线程过多的时候最大可以同时的开启的线程数)
         * 3.超时时间      (当多开出来的线程(5-2) 空闲多久后释放资源)
         * 4. 时间单位
         * 5.阻塞队列  (最多可以有多少个队列在等 (如下 最多可以有3个线程在等 当大于3个的时候开启新的队列 直到到达最大线程数)   )
         * 6.线程工厂 可用默认的
         * 7.拒绝策略 (4种) DiscardPolicy() 队列满了不会抛出异常 但是任务也不会执行(会丢掉任务)   DiscardPolicy()
         * */
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());

        //线程池七大参数
        /*
         * 1.核心线程数   (线程池创建出来的线程数大小)
         * 2.最大线程数   (线程过多的时候最大可以同时的开启的线程数)
         * 3.超时时间      (当多开出来的线程(5-2) 空闲多久后释放资源)
         * 4. 时间单位
         * 5.阻塞队列  (最多可以有多少个队列在等 (如下 最多可以有3个线程在等 当大于3个的时候开启新的队列 直到到达最大线程数)   )
         * 6.线程工厂 可用默认的
         * 7.拒绝策略 (4种) DiscardOldestPolicy() 队列满了不会抛出异常 任务会尝试去或去最早的哪个线程是否结束 如果最早的没结束也会丢掉任务
         * */
        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(2, 5, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardOldestPolicy());


        try {
            for (int i = 0; i < 100; i++) {
                threadPoolExecutor1.execute(()->{
                    System.out.println(Thread.currentThread().getName()+" ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor1.shutdown();
        }
    }
}
