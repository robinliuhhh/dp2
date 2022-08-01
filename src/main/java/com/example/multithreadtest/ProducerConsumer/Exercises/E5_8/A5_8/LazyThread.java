package com.example.multithreadtest.ProducerConsumer.Exercises.E5_8.A5_8;

/**
 * LazyThread类虽然会在Table的实例上进行wait 但该线程并不执行任何实际的操作
 */
public class LazyThread extends Thread {
    private final Table table;

    public LazyThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    public void run() {
        while (true) {
            try {
                synchronized (table) {
                    table.wait();
                }
                System.out.println(getName() + " is notified!");
            } catch (InterruptedException e) {
            }
        }
    }
}
