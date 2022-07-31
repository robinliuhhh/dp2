package com.example.multithreadtest.GuardedSuspension.jucSample;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * GuardedObject 被守护的对象
 * LinkedBlockingQueue版
 * take和put已经考虑了互斥处理（也是基于wait） 所以getRequest和putRequest也就无需声明为synchronized方法
 */
public class RequestQueue {
    private final BlockingQueue<Request> queue = new LinkedBlockingQueue<>();

    public Request getRequest() {
        Request req = null;
        try {
            req = queue.take();
        } catch (InterruptedException e) {
        }
        return req;
    }

    public void putRequest(Request request) {
        try {
            queue.put(request);
        } catch (InterruptedException e) {
        }
    }
}
