package com.example.multithreadtest.ProducerConsumer.Sample;

/**
 * Channel
 * 位于Producer和Consumer之间 保管Data
 * 为确保安全性 对Producer和Consumer的访问进行互斥处理
 * 作为Data的中转站 消除线程间处理速度的差异
 */
public class Table {
    // Data 由Producer生成 供Consumer使用
    private final String[] buffer; // cake

    private int tail;  // 下次put的位置
    private int head;  // 下次take的位置
    private int count; // buffer中的蛋糕个数

    public Table(int count) {
        this.buffer = new String[count];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    // 当看到一个方法被声明可以throws Exception时 可以理解为“该方法可以取消”
    // 放置蛋糕
    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        while (count >= buffer.length) {
            System.out.println(Thread.currentThread().getName() + " wait BEGIN");
            wait();
            System.out.println(Thread.currentThread().getName() + " wait END");
        }
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count++;
        // 蛋糕已经被放置到了桌子上 桌子的状态发生了变化
        // 所以要执行notifyAll 唤醒所有正在wait的线程
        notifyAll();
    }

    // 取蛋糕
    public synchronized String take() throws InterruptedException {
        while (count <= 0) {
            System.out.println(Thread.currentThread().getName() + " wait BEGIN");
            wait();
            System.out.println(Thread.currentThread().getName() + " wait END");
        }
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
