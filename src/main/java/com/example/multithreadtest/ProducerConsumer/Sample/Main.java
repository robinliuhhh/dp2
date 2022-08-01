package com.example.multithreadtest.ProducerConsumer.Sample;

/**
 * Producer -> Channel -> Consumer
 * 使用 synchronized wait notifyAll 等来控制多线程运行的代码都隐藏在了Channel角色中
 */
public class Main {
    public static void main(String[] args) {
        Table table = new Table(3);     // 创建一个能放置3个蛋糕的桌子
        new MakerThread("MakerThread-1", table, 31415).start();
        new MakerThread("MakerThread-2", table, 92653).start();
        new MakerThread("MakerThread-3", table, 58979).start();
        new EaterThread("EaterThread-1", table, 32384).start();
        new EaterThread("EaterThread-2", table, 62643).start();
        new EaterThread("EaterThread-3", table, 38327).start();
    }
}
