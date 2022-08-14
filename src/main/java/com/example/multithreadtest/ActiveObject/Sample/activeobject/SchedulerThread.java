package com.example.multithreadtest.ActiveObject.Sample.activeobject;

/**
 * Scheduler角色
 * 介于 Proxy 角色和 Servant 角色之间 负责管理按照什么顺序执行请求
 *
 * 调用invoke和调用execute方法的是不同的线程
 * invoke:  调用Proxy类的makeString和displayString方法的线程
 * execute: 与SchedulerThread类对应的线程
 */
class SchedulerThread extends Thread {
    private final ActivationQueue queue;

    public SchedulerThread(ActivationQueue queue) {
        this.queue = queue;
    }

    // Producer Client线程调用
    public void invoke(MethodRequest request) {
        queue.putRequest(request);
    }

    // Consumer SchedulerThread新启动线程执行
    public void run() {
        while (true) {
            MethodRequest request = queue.takeRequest();
            request.execute();
        }
    }
}
