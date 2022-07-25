package com.example.multithreadtest.introduction;

/**
 * 1.5 线程的互斥处理
 * <p>
 * 如果有一个线程正在运行 Bank 实例中的 deposit 方法
 * 那么其线程就无法运行这个实例中的 deposit 方法和 withdraw 方法 需要排队等候
 */
public class _5_Bank {
    private int money;
    private String name;

    public _5_Bank(String name, int money) {
        this.name = name;
        this.money = money;
    }

    // 存款
    public synchronized void deposit(int m) {
        money += m;
    }

    // 取款
    public synchronized boolean withdraw(int m) {
        if (money >= m) {
            money -= m;
            return true;    // 取款成功
        } else {
            return false;   // 余额不足
        }
    }

    // getName 并未声明为 synchronized 方法
    // 这是因为该方法并未使用多个线程可同时读写的字段
    public String getName() {
        return name;
    }
}
