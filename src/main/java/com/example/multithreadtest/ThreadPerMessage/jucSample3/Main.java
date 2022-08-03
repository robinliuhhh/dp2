package com.example.multithreadtest.ThreadPerMessage.jucSample3;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        ExecutorService executorService = Executors.newCachedThreadPool();
        Host host = new Host(
                executorService
        );
        try {
            host.request(10, 'A');
            host.request(20, 'B');
            host.request(30, 'C');
        } finally {
            // 通常情况下 在ExecutorService接口后面 线程是一直运行着的
            // 所以ExecutorService接口提供了shutdown方法来结束服务
            executorService.shutdown();
            System.out.println("main END");
        }
    }
}
