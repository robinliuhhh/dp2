package com.example.multithreadtest.WorkerThread.Exercises.E8_3.A8_3a;

/**
 * 移除sleep的Sample 便于对比差异
 */
public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5);   // 工人线程的个数
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chris", channel).start();

        // 运行10s强制退出
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        System.exit(0);
    }

    // output
    // 处理了 534549 + 535321 + 536138 = 1606008 个请求
    // 吞吐量大概是Thread-Per-Message模式的10倍
//    Worker-3 executes [ Request from Alice No.534549 ]
//    Worker-3 executes [ Request from Bobby No.535321 ]
//    Worker-3 executes [ Request from Chris No.536138 ]
}
