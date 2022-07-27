package com.example.multithreadtest.Introduction;

/**
 * 1.2 何谓线程
 * <p>
 * 多线程程序
 */
public class _2_TwoThreads {
    private static class MyThread extends Thread {
        // 4.新线程启动后会调用run()
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.print("Nice!");
            }
        }
    }

    // 1.最开始运行的只能是主线程
    public static void main(String[] args) {
        // 2.所以要在程序中启动新线程 这才能算是多线程程序
        MyThread t = new MyThread();
        // 3.由主线程启动新线程
        t.start();
        for (int i = 0; i < 10000; i++) {
            System.out.print("Good!");
        }
    }

    // output
    // Good!和Nice!交替输出 因为主线程和新线程并发运行
}
