package com.example.multithreadtest.WorkerThread.jucSample;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * 使用Executors.newFixedThreadPool()创建线程池
 * 该线程池保存着指定数量的线程 主线程在5s后shutdown线程池
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        try {
            new ClientThread("Alice", executorService).start();
            new ClientThread("Bobby", executorService).start();
            new ClientThread("Chris", executorService).start();

            // 等待大约5秒
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        } finally {
            executorService.shutdown();
        }
    }
}
