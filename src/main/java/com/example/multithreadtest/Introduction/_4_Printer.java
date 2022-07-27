package com.example.multithreadtest.Introduction;

/**
 * 1.3 线程的启动
 * <p>
 * 利用 Runnable 接口
 * 1.创建Runnable接口的实现类 2.将实现类的实例作为参数传给Thread的构造函数 3.调用start方法
 */
public class _4_Printer {
    private static class Printer implements Runnable {
        private String message;

        public Printer(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                System.out.print(message);
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Printer("Good!")).start();
        new Thread(new Printer("Nice!")).start();
    }
}
