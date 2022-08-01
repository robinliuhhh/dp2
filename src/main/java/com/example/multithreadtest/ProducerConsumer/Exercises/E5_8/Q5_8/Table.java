package com.example.multithreadtest.ProducerConsumer.Exercises.E5_8.Q5_8;

/**
 * notifyAll方法改为了notify方法 使用该类时 有时会出现蛋糕无法正常传递的情况
 * 请思考一下什么情况下会无法正常传递 并编写代码进行验证
 */
public class Table {
    private final String[] buffer;
    private int tail;  // 下次put的位置
    private int head;  // 下次take的位置
    private int count; // buffer中的蛋糕个数

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    // 放置蛋糕
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) {
            wait();
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        notify();
    }

    // 拿取蛋糕
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notify();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
