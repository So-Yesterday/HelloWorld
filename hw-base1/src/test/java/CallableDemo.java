import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                // 模拟一个耗时的任务
                Thread.sleep(5000);
                return 100;
            }
        };

        FutureTask<Integer> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask);
        thread.start();

        // 等待任务执行完毕
        Integer result = futureTask.get();
        System.out.println("任务已经完成，结果为 " + result);

    }
}
