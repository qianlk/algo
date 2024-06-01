package org.example.c3.recursion;

/**
 * 递归二分查找
 *
 * @author qlk
 */
public class E03_BinarySearch {

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

    public static int search(int[] a, int target) {
        return f(a, target, 0, a.length - 1);
    }

    public static void main(String[] args) {
        int[] a = {7, 13, 21, 30, 38, 44, 52, 53};
        System.out.println(search(a, 7) == 0);
        System.out.println(search(a, 30) == 3);
        System.out.println(search(a, 53) == 7);
    }
}
