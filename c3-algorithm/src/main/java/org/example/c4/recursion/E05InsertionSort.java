package org.example.c4.recursion;

/**
 * 递归实现插入排序
 *
 * @author qlk
 */
public class E05InsertionSort {

    public static void sort(int[] a) {
        insertion(a, 1);
    }

    /**
     * @param low 未排序部分的左边界
     */
    private static void insertion(int[] a, int low) {
        if (low == a.length) {
            return;
        }

        int t = a[low];  // 待插入元素
        int i = low - 1;  // i作为已排序部分的右边界
        // 从i开始找
        while (i >= 0 && a[i] > t) {
            a[i + 1] = a[i];
            i--;
        }

        // 找到插入位置
        if (i + 1 != low) {
            a[i + 1] = t;
        }

        insertion(a, low + 1);

    }
}
