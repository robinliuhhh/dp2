package com.example.multithreadtest.WorkerThread.jucSample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.Random;

public class ClientThread extends Thread {
    private final ExecutorService executorService;
    private static final Random random = new Random();

    public ClientThread(String name, ExecutorService executorService) {
        super(name);
        this.executorService = executorService;
    }

    public void run() {
        try {
            for (int i = 0; true; i++) {
                Request request = new Request(getName(), i);
                // Request implements Runnable
                // 因此ExecutorService才能通过execute方法执行Request的run方法
                executorService.execute(request);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
        } catch (RejectedExecutionException e) {
            // 当ExecutorService被shutdown
            // execute方法会被reject 并抛出RejectedExecutionException
            System.out.println(getName() + " : " + e);
        }
    }
}
