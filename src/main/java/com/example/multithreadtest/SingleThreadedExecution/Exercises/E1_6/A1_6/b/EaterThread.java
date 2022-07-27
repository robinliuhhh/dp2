package com.example.multithreadtest.SingleThreadedExecution.Exercises.E1_6.A1_6.b;

public class EaterThread extends Thread {
    private String name;
    private final Pair pair;

    public EaterThread(String name, Pair pair) {
        this.name = name;
        this.pair = pair;
    }

    public void run() {
        while (true) {
            eat();
        }
    }

    public void eat() {
        // 锁住整个SharedResource
        synchronized (pair) {
            System.out.println(name + " takes up " + pair + ".");
            System.out.println(name + " is eating now, yum yum!");
            System.out.println(name + " puts down " + pair + ".");
        }
    }
}
