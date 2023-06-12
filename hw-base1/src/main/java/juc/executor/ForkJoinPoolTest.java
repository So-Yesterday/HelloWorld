package juc.executor;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTest {
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();  // 创建 ForkJoinPool 对象

        int[] arr = new int[1000];  // 创建一个数组
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int result = pool.invoke(new SumTask(arr, 0, arr.length));  // 执行任务并获取结果
        System.out.println("数组元素和：" + result);
    }

    private static class SumTask extends RecursiveTask<Integer> {
        private final int[] arr;
        private final int start;
        private final int end;

        public SumTask(int[] arr, int start, int end) {
            this.arr = arr;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            if (end - start <= 10) {  // 如果任务太小，直接计算结果
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += arr[i];
                }
                return sum;
            } else {  // 如果任务太大，拆分成子任务并行执行
                int mid = (start + end) / 2;
                SumTask leftTask = new SumTask(arr, start, mid);
                SumTask rightTask = new SumTask(arr, mid, end);
                invokeAll(leftTask, rightTask);  // 并行执行子任务
                int leftResult = leftTask.join();  // 获取左子任务的执行结果
                int rightResult = rightTask.join();  // 获取右子任务的执行结果
                return leftResult + rightResult;  // 合并子任务的执行结果
            }
        }
    }
}
