package com.example.multithreadtest.TwoPhaseTermination.Sample;

/**
 * 第一阶段: 操作中 -> 终止处理中
 * 第二阶段: 终止处理中 -> 终止
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main: BEGIN");
        try {
            // 启动线程
            CountupThread t = new CountupThread();
            t.start();

            // 稍微间隔一段时间
            Thread.sleep(10000);

            // 线程的终止请求
            System.out.println("main: shutdownRequest");
            t.shutdownRequest();

            // 等待CountupThread线程终止
            System.out.println("main: join");
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main: END");
    }

    // output
    /*
        main: BEGIN
        doWork: counter = 1
        doWork: counter = 2
        doWork: counter = 3
        doWork: counter = 4
        doWork: counter = 5
        doWork: counter = 6
        doWork: counter = 7
        doWork: counter = 8
        doWork: counter = 9
        doWork: counter = 10
        doWork: counter = 11
        doWork: counter = 12
        doWork: counter = 13
        doWork: counter = 14
        doWork: counter = 15
        doWork: counter = 16
        doWork: counter = 17
        doWork: counter = 18
        doWork: counter = 19
        doWork: counter = 20
        main: shutdownRequest
        main: join
        doShutdown: counter = 20
        main: END
    */
}
