package com.example.multithreadtest.WorkerThread.Exercises.E8_3.A8_3b;

/**
 * 使用Thread-Per-Message模式 和Worker Thread模式A8_3a对比吞吐量
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
    // 处理了 59775 + 58073 + 60270 = 178118 个请求
//    Thread-178105 executes [ Request from Alice No.59775 ]
//    Thread-178117 executes [ Request from Chris No.58073 ]
//    Thread-178122 executes [ Request from Bobby No.60270 ]
}
