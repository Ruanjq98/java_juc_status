package callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author ruanjq
 * @version 1.0
 * @date 2021/8/1610:41
 **/
public class CallableTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);

    }

}
class MyThread implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println("call()"); // 会打印几个call // 耗时的操作
        return 1024;
    }
}