package org.example.c3.binarysearch;

/**
 * @author qlk
 */
public class E69_Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int i = 0, j = x - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (!sqrtBigThan(m, x)) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return j;
    }

    boolean sqrtBigThan(int m, int target) {
        double msqrt = m * m * 1d;
        if (msqrt < 0) {
            return true;
        }

        return msqrt > target;
    }

    public static void main(String[] args) {
        E69_Sqrt e69Sqrt = new E69_Sqrt();
        e69Sqrt.mySqrt(2147395599);
    }
}
