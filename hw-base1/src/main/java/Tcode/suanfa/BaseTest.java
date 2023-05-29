package Tcode.suanfa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BaseTest {
    @Test
    public void test() {
        // 二分查找
        int[] binary = new int[]{1, 5, 6, 7, 19, 60, 45};
        System.out.println(binarySearch(binary, 12));

        //bubbleSort
        int[] bubbleSort = new int[]{11, 5, 16, 7, 19, 6, 45};
        System.out.println(Arrays.toString(bubbleSort(bubbleSort)));


    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    public int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j <= arr.length - i - 1; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }


}
