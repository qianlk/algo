package org.example.c3.recursion;

import java.util.Arrays;

/**
 * 递归冒泡排序
 *
 * @author qlk
 */
public class E04_BubbleSort {

    public static void sort(int[] a) {
        bubble(a, a.length - 1);
    }

    private static void bubble(int[] a, int j) {
        if (j == 0) {
            return;
        }
        // 引入变量,代替j作为新的边界
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                // 发生交换时,i的右侧局部递增
                // 最后一次交换,i的右侧绝对递增
                x = i;
            }
        }
//        bubble(a, j - 1);
        bubble(a, x);
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
//        bubble(a, a.length - 1);
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
