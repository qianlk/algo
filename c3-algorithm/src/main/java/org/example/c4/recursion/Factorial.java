package org.example.c4.recursion;

/**
 * 递归
 *
 * @author qlk
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(f(5));
    }

    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }
}
