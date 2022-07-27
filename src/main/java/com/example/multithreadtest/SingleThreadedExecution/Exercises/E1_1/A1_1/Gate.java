package com.example.multithreadtest.SingleThreadedExecution.Exercises.E1_1.A1_1;

/**
 * 思路
 *
 * 延长临界区可以提高检查出错误的可能性
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

    public void pass(String name, String address) {
        this.counter++;
        this.name = name;

        // 方法2 测试结果相反
        // 让出CPU执行权 不会让出锁 加快线程的切换
        // yield 让出自己剩余的时间片 并没有被阻塞挂起 而是处于就绪状态
        // todo
        // Thread.yield();

        // 方法1
        // 暂停线程 不会让出锁
        // sleep 被阻塞挂起指定的时间
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        this.address = address;
        check();
    }

    public String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }

    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ***** " + toString());
        }
    }
}
