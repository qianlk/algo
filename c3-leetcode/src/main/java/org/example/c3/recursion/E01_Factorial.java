package org.example.c3.recursion;

/**
 * 阶乘
 *
 * @author qlk
 */
public class E01_Factorial {

    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);


    }

    public static void main(String[] args) {
        System.out.println(f(3));
        System.out.println(f(5));
    }
}
