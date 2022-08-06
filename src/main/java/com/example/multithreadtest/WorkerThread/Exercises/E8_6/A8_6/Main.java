package com.example.multithreadtest.WorkerThread.Exercises.E8_6.A8_6;

/**
 * 为了能够在运行大约5s后停止 对Main类做了如下修改 请据此对其他类作以下修改
 * 1.在Channel类增加stopAllWorkers方法 终止Channel类保存的所有WorkerThread线程
 * 2.在ClientThread增加stopThread方法 终止ClientThread线程
 */
public class Main {
    public static void main(String[] args) {
        Channel channel = new Channel(5);   // 工人线程的个数
        channel.startWorkers();
        ClientThread alice = new ClientThread("Alice", channel);
        ClientThread bobby = new ClientThread("Bobby", channel);
        ClientThread chris = new ClientThread("Chris", channel);
        alice.start();
        bobby.start();
        chris.start();

        // 运行大约5s后停止
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        alice.stopThread();
        bobby.stopThread();
        chris.stopThread();
        channel.stopAllWorkers();
    }
}
