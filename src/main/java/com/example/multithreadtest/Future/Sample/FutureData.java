package com.example.multithreadtest.Future.Sample;

public class FutureData implements Data {
    private RealData realdata = null;
    private boolean ready = false;

    public synchronized void setRealData(RealData realdata) {
        if (ready) {
            return;     // Balk模式 防止重复调用（非必需）
        }
        this.realdata = realdata;
        this.ready = true;
        notifyAll();
    }

    public synchronized String getContent() {
        while (!ready) {
            try {
                wait(); // Guarded Suspension模式
            } catch (InterruptedException e) {
            }
        }
        return realdata.getContent();
    }
}
