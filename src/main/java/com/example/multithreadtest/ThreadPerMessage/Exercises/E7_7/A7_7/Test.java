package com.example.multithreadtest.ThreadPerMessage.Exercises.E7_7.A7_7;

/**
 * 测试永远不会返回的线程写法 程序停住不动
 */
public class Test {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                synchronized (this) { // 获取当前线程的锁
                    System.out.println("after synchronized (this)");
                }
                try {
                    System.out.println("join");
                    this.join(); // 当前线程一直等待自身终止
                } catch (InterruptedException e) {
                }
            }
        }.start();
    }
}
