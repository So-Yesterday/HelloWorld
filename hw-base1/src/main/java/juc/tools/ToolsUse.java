package juc.tools;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ToolsUse {


    @Test
    public void testLockCondition() {
        ReentrantLock lock = new ReentrantLock();
        // 锁的状态下,控制线程等待和唤醒
        Condition condition = lock.newCondition();

        lock.lock();
        try {

            condition.await();
            //doing
            condition.signal();
            condition.signalAll();
        } catch (Exception ignored) {

        } finally {
            lock.unlock();
        }

    }


    @Test
    public void testSemaphore() throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);

        // 获取许可证
        semaphore.acquire();
        try {
            //doing
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放许可证
            semaphore.release();
        }
    }


    @Test
    public void testCountDownLatch() throws InterruptedException {
        // 线程计数器
        CountDownLatch latch = new CountDownLatch(10);

        try {
            //doing
            latch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        latch.await();

    }

    @Test
    public void testCyclicBarrier() throws InterruptedException, BrokenBarrierException {
        // CyclicBarrier 是一个循环栅栏，用于等待多个线程执行到某个状态后再继续执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        // 10个线程 都执行完
        cyclicBarrier.await();
    }


}
