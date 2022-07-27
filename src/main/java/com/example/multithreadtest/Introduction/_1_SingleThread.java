package com.example.multithreadtest.Introduction;

/**
 * 1.2 何谓线程
 * <p>
 * 单线程程序
 */
public class _1_SingleThread {
    // 单线程 只有主线程main在运行
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            System.out.print("Good!");
        }
    }
}
