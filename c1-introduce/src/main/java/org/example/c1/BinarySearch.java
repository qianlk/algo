package org.example.c1;

/**
 * @author qlk
 */
public class BinarySearch {
//    public static void main(String[] args) {
//        BinarySearch bs = new BinarySearch();
//        int[] a = new int[] {1, 3, 5, 7, 9};
//
//        System.out.println(bs.binarySearchBasic(a, 5));
//        System.out.println(bs.binarySearchBasic(a, 4));
//
//
//    }

    /**
     * 基础版二分查找
     */
    public static int binarySearchBasic(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
//            int m = (i + j) / 2;
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (target > a[m]) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
//        return i;  // 返回的i表示插入点
    }

    /**
     * 替代版二分查找
     * <p>
     * 改变j的取值
     * 改变搜索条件
     * 改变j的赋值
     */
    public static int binarySearchAlternative(int[] a, int target) {
        int i = 0, j = a.length;
        while (i < j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                return m;
            }
        }
        return -1;
    }

    /**
     * 平衡版二分查找
     * <p>
     * 最好和最坏的时间复杂度都是$\theta(log(n))$
     */
    public static int binarySearchBalance(int[] a, int target) {
        int i = 0, j = a.length;
        while (1 < j - i) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m;
            } else {
                i = m;
            }
        }
        if (a[i] == target) {
            return i;
        } else {
            return -1;
//            return i + 1;  // 表示插入点
        }
    }

    /**
     * 二分查找 Leftmost
     * <p>
     * 返回重复元素的的最左侧元素
     */
    public static int binarySearchLeftmost1(int[] a, int target) {
        int i = 0, j = a.length - 1, candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (target > a[m]) {
                i = m + 1;
            } else {
                // 不直接返回,继续向左找
                candidate = m;
                j = m - 1;
            }
        }
        return candidate;
    }

    /**
     * 二分查找 Rightmost
     */
    public static int binarySearchRightmost1(int[] a, int target) {
        int i = 0, j = a.length - 1, candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (target > a[m]) {
                i = m + 1;
            } else {
                // 不直接返回,继续向左找
                candidate = m;
                i = m + 1;
            }
        }
        return candidate;
    }

    /**
     * 二分查找 Leftmost 版本2
     * 返回i表示:
     * 找到时,返回与目标值相等的最靠左的位置的元素下标
     * 没找到时,返回比目标值大的最靠左的位置的元素下标
     * <p>
     * ==>
     * 返回大于等于目标值的最靠左的元素下标
     */
    public static int binarySearchLeftmost2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    /**
     * 二分查找 Leftmost 版本2
     * 返回小于等于目标值的最靠右的元素下标
     */
    public static int binarySearchRightmost2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (a[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
//        return i - 1;
        return j;
    }
}
