package com.example.multithreadtest.Balking.Timeout;

import java.util.concurrent.TimeoutException;

/**
 * 介于Guarded Suspension和Balking之间 称为guarded timed或timeout
 * 在守护条件成立之前等待一段时间 如果到时条件还未成立 则balk
 */
public class Host {
    private final long timeout; // 超时时间
    private boolean ready = false; // 方法正常执行时值为true

    public Host(long timeout) {
        this.timeout = timeout;
    }

    // StateChangingMethod
    // 修改状态
    public synchronized void setExecutable(boolean on) {
        ready = on;
        notifyAll();
    }

    // GuardedMethod
    // 检查状态之后再执行
    public synchronized void execute() throws InterruptedException, TimeoutException {
        long start = System.currentTimeMillis(); // 开始时间
        while (!ready) {
            long now = System.currentTimeMillis(); // 当前时间
            long rest = timeout - (now - start); // 剩余的等待时间
            if (rest <= 0) {
                throw new TimeoutException("now - start = " + (now - start) + ", timeout = " + timeout);
            }
            wait(rest);
        }
        doExecute();
    }

    // 实际的处理
    private void doExecute() {
        System.out.println(Thread.currentThread().getName() + " calls doExecute");
    }
}
