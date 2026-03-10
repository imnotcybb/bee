package com.cybb.bee;

public class Main3 {
    public static void main(String[] args) {
        func(57);
    }

    /**
     * 打印 [0,n] 内的所有偶数
     */
    public static void func(int n) {
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            } else {
                System.out.println("奇数是" + i);
            }
        }
    }

    /**
     * 打印 [0,n] 内的所有以 m 结尾的数字
     */
    public static void func(int n, int m) {
        for (int i = 0; i <= n; i++) {
            if ((i - m) % 10 == 0) {
                System.out.println(i);
            }
        }

    }
}