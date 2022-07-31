package com.example.multithreadtest.GuardedSuspension.Sample;

/**
 * 简单的线程间通信
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        // 3141592L 6535897L用来作为随机数的种子 并没有什么特别意义
        new ClientThread(requestQueue, "Alice", 3141592L).start();
        new ServerThread(requestQueue, "Bobby", 6535897L).start();
    }
}
