package org.example.c4.recursion;

/**
 * 反向打印字符串
 * 递归方式
 *
 * @author qlk
 */
public class ReversePrintString {
    public static void main(String[] args) {
        f("abcd", 0);
    }

    public static void f(String str, int n) {
        if (n == str.length()) {
           return;
        }
        f(str, n + 1);
        print(str.charAt(n));
    }

    public static void print(Object obj) {
        System.out.println(obj);
    }
}
