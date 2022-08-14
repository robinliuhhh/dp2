package com.example.multithreadtest.ThreadSpecificStorage.Sample2;

/**
 * Client
 */
public class ClientThread extends Thread {
    public ClientThread(String name) {
        super(name);
    }

    public void run() {
        System.out.println(getName() + " BEGIN");
        for (int i = 0; i < 10; i++) {
            // Main.1 调用的是 Log 类的同一个方法
            Log.println("i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        Log.close();
        System.out.println(getName() + " END");
    }
}
