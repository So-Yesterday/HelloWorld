package Tcode.question;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerAndConsumerTest {
    //线程A向队列Q中不停写入数据，线程B从队列Q中不停读取数据（只要Q中有数据）。
    private static BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(10); // 定义阻塞队列Q

    public static void main(String[] args) {

        Thread producerThread = new Thread(new Producer());
        Thread consumerThread = new Thread(new Consumer());

        producerThread.start();
        consumerThread.start();

    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    queue.put(i++);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
