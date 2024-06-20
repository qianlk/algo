package org.example.c4.recursion;

/**
 * 二分查找递归版
 *
 * @author qlk
 */
public class E03BinarySearch {

    public static int search(int[] a, int target) {
        return f(a, target, 0, a.length - 1);
    }

    private static int f(int[] a, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;
        if (target < a[m]) {
            return f(a, target, i, m - 1);
        } else if (a[m] < target) {
            return f(a, target, m + 1, j);
        } else {
            return m;
        }
    }
}
