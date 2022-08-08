package com.example.multithreadtest.TwoPhaseTermination.jucSample1;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.CountDownLatch;

/**
 * 当我们想让某个线程等待指定的线程终止时 可以使用join
 * 但是join方法可以等待的只是“线程终止”这个一次性的操作
 * 使用java.util.concurrent.CountDownLatch类可以实现“等待指定次数的CountDown方法被调用”这一功能
 */
// 让线程处理10项MyTask工作 并等待10项工作都处理完成
public class Main {
    private static final int TASKS = 10; // 工作的个数

    public static void main(String[] args) {
        System.out.println("BEGIN");
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch doneLatch = new CountDownLatch(TASKS);
        try {
            // 开始工作
            for (int t = 0; t < TASKS; t++) {
                service.execute(new MyTask(doneLatch, t));
            }
            System.out.println("AWAIT");
            // 等待工作结束
            doneLatch.await();
        } catch (InterruptedException e) {
        } finally {
            // 终止在该ExecutorService中启动的所有线程
            service.shutdown();
            System.out.println("END");
        }
    }

    // output
    /*
        BEGIN
        AWAIT
        pool-1-thread-1:MyTask:BEGIN:context = 0
        pool-1-thread-5:MyTask:BEGIN:context = 4
        pool-1-thread-4:MyTask:BEGIN:context = 3
        pool-1-thread-2:MyTask:BEGIN:context = 1
        pool-1-thread-3:MyTask:BEGIN:context = 2
        pool-1-thread-2:MyTask:END:context = 1
        pool-1-thread-2:MyTask:BEGIN:context = 5
        pool-1-thread-5:MyTask:END:context = 4
        pool-1-thread-5:MyTask:BEGIN:context = 6
        pool-1-thread-5:MyTask:END:context = 6
        pool-1-thread-5:MyTask:BEGIN:context = 7
        pool-1-thread-2:MyTask:END:context = 5
        pool-1-thread-2:MyTask:BEGIN:context = 8
        pool-1-thread-1:MyTask:END:context = 0
        pool-1-thread-1:MyTask:BEGIN:context = 9
        pool-1-thread-5:MyTask:END:context = 7
        pool-1-thread-3:MyTask:END:context = 2
        pool-1-thread-4:MyTask:END:context = 3
        pool-1-thread-2:MyTask:END:context = 8
        pool-1-thread-1:MyTask:END:context = 9
        END
    */
}
