package callable;

import java.util.concurrent.CountDownLatch;

/**
 * @author ruanjq
 * @version 1.0
 * @date 2021/8/1610:54
 **/

public class CountDownLatchDome  {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);//减法计数器

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"getout");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("close ");
    }
}
