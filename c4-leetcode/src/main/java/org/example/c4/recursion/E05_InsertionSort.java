package org.example.c4.recursion;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author qlk
 */
public class E05_InsertionSort {

    public static void sort(int[] a) {
        insertion(a, 1);
    }

    private static void insertion(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        int t = a[low];
        int i = low - 1;

        while (i >= 0 && a[i] > t) {
            a[i + 1] = a[i];
            i--;
        }

        // 找到插入位置
        if (i+1 != low) {
            a[i + 1] = t;
        }
        insertion(a, low + 1);
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1};

        sort(a);
        System.out.println(Arrays.toString(a));
    }
}
