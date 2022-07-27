package com.example.multithreadtest.Introduction;

/**
 * 1.3 线程的启动
 * <p>
 * 利用 Thread 类的子类
 * 1.创建Thread类的子类 2.创建子类的实例 3.调用start方法
 */
public class _3_PrintThread {
    private static class PrintThread extends Thread {
        private String message;

        public PrintThread(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.print(message);
            }
        }
    }

    // main 方法中启动了两个线程 随后 main 方法便会终止 主线程也会跟着终止
    // 但整个程序并不会随之终止 因为启动的两个线程在字符串输出之前是不会终止的
    // 直到所有的线程都终止后 程序才会终止
    public static void main(String[] args) {
        // 输出的字符串通过构造函数的参数传入
        new PrintThread("Good!").start();
        new PrintThread("Nice!").start();
    }
}
