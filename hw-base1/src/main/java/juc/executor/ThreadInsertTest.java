package juc.executor;


import java.util.concurrent.*;

public class ThreadInsertTest {

    public static ThreadPoolExecutor executor = new ThreadPoolExecutor(2,
            4,
            10,
             TimeUnit.SECONDS,
             new LinkedBlockingQueue<>(),
             Executors.defaultThreadFactory(),
             new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) throws InterruptedException {


        CountDownLatch countDownLatch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            executor.execute(()->{
                try {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+"执行");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        countDownLatch.await();
        System.out.println("全部执行完毕??");

    }



}
