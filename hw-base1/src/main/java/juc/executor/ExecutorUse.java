package juc.executor;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ExecutorUse {


    @Test
    public void executrTest() throws ExecutionException, InterruptedException {

        // 用于执行异步任务
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        executorService.execute(() -> {
            // 接受Runnable 接口执行
        });

        // 可接收 callable 或runnable 接口
        Future<String> future = executorService.submit(() -> "call 执行");
        String result = future.get();


        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();  // 创建单线程池

        executor.schedule(() -> {
            // 延迟执行任务
        }, 1, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(() -> {
            // 固定时间间隔执行任务
        }, 1, 1, TimeUnit.SECONDS);


        ThreadPoolExecutor executor2
                = new ThreadPoolExecutor(
                10,  // 核心线程数
                20,  // 最大线程数
                60, TimeUnit.SECONDS,  // 线程最大空闲时间
                new ArrayBlockingQueue<>(100),  // 等待队列类型
                new ThreadPoolExecutor.AbortPolicy()  // 拒绝策略
        );

        executor2.execute(() -> {
            // 执行异步任务
        });


    }


}
