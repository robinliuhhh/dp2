package com.example.multithreadtest.WorkerThread.Exercises.E8_6.A8_6;

/**
 * 这里不使用Thread类的stop方法 因为即使是加锁的线程也会被stop方法立即终止 所以它无法确保安全性
 * 我们借助interrupt和抛异常来实现（如果是java.util.concurrent.ThreadPoolExecutor创建的线程 只需调用shutdown即可）
 * 1.ClientThread和WorkerThread调用interrupt中断自身线程
 * 2.Channel类感知到并抛出InterruptedException
 * 3.调用方ClientThread和WorkerThread能够catch InterruptedException 做后续处理
 */
public final class Channel {
    private static final int MAX_REQUEST = 100;
    private final Request[] requestQueue;
    private int tail;  // 下次putRequest的位置
    private int head;  // 下次takeRequest的位置
    private int count; // Request的数量

    private final WorkerThread[] threadPool;

    public Channel(int threads) {
        this.requestQueue = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;

        threadPool = new WorkerThread[threads];
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i] = new WorkerThread("Worker-" + i, this);
        }
    }

    public void startWorkers() {
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].start();
        }
    }

    public void stopAllWorkers() {
        for (int i = 0; i < threadPool.length; i++) {
            threadPool[i].stopThread();
        }
    }

    public synchronized void putRequest(Request request) throws InterruptedException {
        while (count >= requestQueue.length) {
            wait();
        }
        requestQueue[tail] = request;
        tail = (tail + 1) % requestQueue.length;
        count++;
        notifyAll();
    }

    public synchronized Request takeRequest() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        Request request = requestQueue[head];
        head = (head + 1) % requestQueue.length;
        count--;
        notifyAll();
        return request;
    }
}
