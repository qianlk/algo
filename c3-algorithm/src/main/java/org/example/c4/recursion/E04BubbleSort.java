package org.example.c4.recursion;

import java.util.Arrays;

/**
 * @author qlk
 */
public class E04BubbleSort {

    public static void sort(int[] a) {
        bubble(a, a.length - 1);
    }

    /*private static void bubble(int[] arr, int j) {
        if (j == 0) {
            return;
        }

        // 一轮排序,冒泡出最大值
        for (int i = 0; i < j; i++) {
            // 比较当前值和后一个值
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // 一轮排序后, 最后一位是最大值, -1继续调用
        bubble(arr, j - 1);
    }*/

    // 优化版本
    // 引入变量x, 每当发生交换时, 将i的值赋值给x
    // 这样在最后一次交换后, x之后的元素都将是有序的, 下一次冒泡七点可以从x开始
    private static void bubble(int[] arr, int j) {
        if (j == 0) {
            return;
        }

        int x = 0;
        // 一轮排序,冒泡出最大值
        for (int i = 0; i < j; i++) {
            // 比较当前值和后一个值
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                x = i;
            }
        }

        // 一轮排序后, 最后一位是最大值, -1继续调用
        bubble(arr, x);
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        bubble(a, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
