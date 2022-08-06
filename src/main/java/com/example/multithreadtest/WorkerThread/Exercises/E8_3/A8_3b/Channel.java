package com.example.multithreadtest.WorkerThread.Exercises.E8_3.A8_3b;

public final class Channel {
    public Channel(int threads) {
    }

    public void startWorkers() {
    }

    public void putRequest(final Request request) {
        new Thread(() -> request.execute()).start();
    }
}
