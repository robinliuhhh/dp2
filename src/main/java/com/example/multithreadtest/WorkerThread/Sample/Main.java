package com.example.multithreadtest.WorkerThread.Sample;

/**
 * Client -Request-> Channel -Request-> Worker(Request.execute())
 * 也可称为background thread模式 或 thread pool模式
 */
public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5);   // 工人线程的个数
        channel.startWorkers();
        new ClientThread("Alice", channel).start();
        new ClientThread("Bobby", channel).start();
        new ClientThread("Chris", channel).start();
    }
}
