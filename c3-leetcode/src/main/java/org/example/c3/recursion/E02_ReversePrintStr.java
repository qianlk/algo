package org.example.c3.recursion;

/**
 * 反向打印字符串
 *
 * @author qlk
 */
public class E02_ReversePrintStr {

    public static void f(String str, int n) {
        if (n == str.length()) {
            return;
        }
        f(str, n + 1);
        System.out.println(str.charAt(n));
    }

    public static void main(String[] args) {
        f("你好", 0);
    }
}
