package com.example.multithreadtest.WorkerThread.Exercises.E8_3.A8_3a;

public class ClientThread extends Thread {
    private final Channel channel;

    public ClientThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    public void run() {
        for (int i = 0; true; i++) {
            Request request = new Request(getName(), i);
            channel.putRequest(request);
        }
    }
}
