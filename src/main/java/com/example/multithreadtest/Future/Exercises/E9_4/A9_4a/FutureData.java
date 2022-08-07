package com.example.multithreadtest.Future.Exercises.E9_4.A9_4a;

import java.util.concurrent.ExecutionException;

public class FutureData implements Data {
    private RealData realdata = null;
    private ExecutionException exception = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realdata) {
        if (ready) {
            return;
        }
        this.realdata = realdata;
        this.ready = true;
        notifyAll();
    }

    public synchronized void setException(Throwable throwable) {
        if (ready) {
            return;
        }
        this.exception = new ExecutionException(throwable);
        this.ready = true;
        notifyAll();
    }

    // 抛出异常 主线程调用此方法时就可以感知到了
    // 为了不去关心实际可能发生的异常 这里用ExecutionException包装具体的异常
    public synchronized String getContent() throws ExecutionException {
        while (!ready) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        if (exception != null) {
            throw exception;
        }
        return realdata.getContent();
    }
}
