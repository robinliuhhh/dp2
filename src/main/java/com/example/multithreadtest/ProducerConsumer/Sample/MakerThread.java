package com.example.multithreadtest.ProducerConsumer.Sample;

import java.util.Random;

/**
 * Producer
 * 生成Data 传递给Channel
 */
public class MakerThread extends Thread {
    // 非静态成员属于实例对象 只有在对象实例化之后才存在 需要通过类的实例对象去访问
    private final Random random;
    private final Table table;
    // 静态成员是属于类的 在类加载的时候就会分配内存 可以通过类名直接访问
    private static int id = 0; // 蛋糕的流水号(所有糕点师MakerThread共用 所以声明为static 通过类访问 而不是通过实例)

    public MakerThread(String name, Table table, long seed) {
        super(name);
        this.table = table;
        this.random = new Random(seed);
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                String cake = "[ Cake No." + nextId() + " by " + getName() + " ]";
                table.put(cake);
            }
        } catch (InterruptedException e) {
        }
    }

    // 静态方法为什么不能调用非静态成员?
    // 在类的非静态成员不存在的时候静态成员就已经存在了 此时调用在内存中还不存在的非静态成员 属于非法操作
    private static synchronized int nextId() {
        return id++;
    }
}
