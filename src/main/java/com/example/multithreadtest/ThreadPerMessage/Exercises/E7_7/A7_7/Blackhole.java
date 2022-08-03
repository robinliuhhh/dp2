package com.example.multithreadtest.ThreadPerMessage.Exercises.E7_7.A7_7;

/**
 * 思路分析
 * 1.Step 2被输出了 说明magic未抛出异常
 * 2.END未被输出 说明线程未能从enter返回
 * 3.Step 3未被输出 说明线程未能获取obj的锁而阻塞
 *
 * 由此可知 magic的操作是获取obj的锁 且线程从magic返回时不能释放该锁
 * 1.在magic方法中启动新线程获取obj的锁
 * 2.在新线程已启动但尚未获取obj的锁之前 原线程不能从magic返回
 * 3.新线程一直持有obj的锁
 */
public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step 2");
        synchronized (obj) {
            System.out.println("Step 3 (never reached here)");  // 不会执行到这里
        }
    }

    // 为了将参数obj传给内部类的run方法 将其声明为final类型
    public static void magic(final Object obj) {
        Thread thread = new Thread() {
            // 新线程开始执行
            public void run() {
                System.out.println("before synchronized (obj)");
                synchronized (obj) {        // 新线程在此处获取obj的锁
                    synchronized (this) {   // 获取新线程的锁
                        System.out.println("notifyAll");
                        this.notifyAll();   // 通知原线程已经获取了obj的锁
                    }
                    try {
                        System.out.println("join");
                        this.join(); // 新线程一直等待自身终止 程序会停住不动
                    } catch (InterruptedException e) {
                    }
                }
            }
        };

        // 原线程从此处开始
        synchronized (thread) {
            thread.start();     // 原线程启动新线程
            try {
                System.out.println("wait");
                thread.wait();  // 原线程一直wait 直到新线程获取obj的锁
                // 原线程从magic返回
            } catch (InterruptedException e) {
            }
        }
    }

    // output
    /*
    wait
    before synchronized (obj)
    notifyAll
    join
     */
}
