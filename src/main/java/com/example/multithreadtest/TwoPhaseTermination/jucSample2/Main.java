package com.example.multithreadtest.TwoPhaseTermination.jucSample2;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch类只能进行倒数计数 也就是说 一旦计数值变为0后 即使调用await方法 主线程也会立即返回
 * 当想多次重复进行线程同步时 使用java.util.concurrent.CyclicBarrier类会很方便
 * CyclicBarrier可以周期性地(cyclic)创建出屏障(barrier)
 * 在屏障解除之前 碰到屏障的线程无法继续前进 屏障的解除条件是到达屏障处的线程个数达到了构造函数指定的个数
 */
// 除非3个线程都结束第 N 阶段的处理 否则哪个线程都不能进入第 N+1 阶段
public class Main {
    private static final int THREADS = 3; // 线程的个数

    public static void main(String[] args) {
        System.out.println("BEGIN");

        // 由ExecutorService提供进行工作的线程
        ExecutorService service = Executors.newFixedThreadPool(THREADS);

        // 屏障被解除时的操作
        Runnable barrierAction = new Runnable() {
            public void run() {
                System.out.println("Barrier Action!");
            }
        };

        // CyclicBarrier用于使线程步调一致
        // 在创建CyclicBarrier的实例时可以指定Runnable对象
        // 这个对象被称作“屏障操作” 每次屏障被解除后 该屏障操作都会被执行
        CyclicBarrier phaseBarrier = new CyclicBarrier(THREADS, barrierAction);

        // CountDownLatch用于确认工作是否结束
        CountDownLatch doneLatch = new CountDownLatch(THREADS);

        try {
            // 开始工作
            for (int t = 0; t < THREADS; t++) {
                service.execute(new MyTask(phaseBarrier, doneLatch, t));
            }
            // 等待工作结束
            // 通知主线程“所有工作的各个阶段都已结束”
            System.out.println("AWAIT");
            doneLatch.await();
        } catch (InterruptedException e) {
        } finally {
            service.shutdown();
            System.out.println("END");
        }
    }

    // output
    /*
        BEGIN
        AWAIT
        pool-1-thread-1:MyTask:BEGIN:context = 0, phase = 0
        pool-1-thread-3:MyTask:BEGIN:context = 2, phase = 0
        pool-1-thread-2:MyTask:BEGIN:context = 1, phase = 0
        pool-1-thread-3:MyTask:END:context = 2, phase = 0
        pool-1-thread-1:MyTask:END:context = 0, phase = 0
        pool-1-thread-2:MyTask:END:context = 1, phase = 0
        Barrier Action!
        pool-1-thread-2:MyTask:BEGIN:context = 1, phase = 1
        pool-1-thread-3:MyTask:BEGIN:context = 2, phase = 1
        pool-1-thread-1:MyTask:BEGIN:context = 0, phase = 1
        pool-1-thread-2:MyTask:END:context = 1, phase = 1
        pool-1-thread-1:MyTask:END:context = 0, phase = 1
        pool-1-thread-3:MyTask:END:context = 2, phase = 1
        Barrier Action!
        pool-1-thread-3:MyTask:BEGIN:context = 2, phase = 2
        pool-1-thread-2:MyTask:BEGIN:context = 1, phase = 2
        pool-1-thread-1:MyTask:BEGIN:context = 0, phase = 2
        pool-1-thread-3:MyTask:END:context = 2, phase = 2
        pool-1-thread-2:MyTask:END:context = 1, phase = 2
        pool-1-thread-1:MyTask:END:context = 0, phase = 2
        Barrier Action!
        pool-1-thread-1:MyTask:BEGIN:context = 0, phase = 3
        pool-1-thread-3:MyTask:BEGIN:context = 2, phase = 3
        pool-1-thread-2:MyTask:BEGIN:context = 1, phase = 3
        pool-1-thread-3:MyTask:END:context = 2, phase = 3
        pool-1-thread-2:MyTask:END:context = 1, phase = 3
        pool-1-thread-1:MyTask:END:context = 0, phase = 3
        Barrier Action!
        pool-1-thread-1:MyTask:BEGIN:context = 0, phase = 4
        pool-1-thread-3:MyTask:BEGIN:context = 2, phase = 4
        pool-1-thread-2:MyTask:BEGIN:context = 1, phase = 4
        pool-1-thread-2:MyTask:END:context = 1, phase = 4
        pool-1-thread-3:MyTask:END:context = 2, phase = 4
        pool-1-thread-1:MyTask:END:context = 0, phase = 4
        Barrier Action!
        END
     */
}
