package com.example.multithreadtest.SingleThreadedExecution.Exercises.E1_6.Q1_6;

/**
 * 问题描述
 *
 * 请试着修改该程序 避免死锁的发生
 *
 * 死锁发生条件
 * 1.存在多个 SharedResource 角色
 * 2.线程在持有着某个 SharedResource 角色的锁的同时 还想获取其他 SharedResource 角色的锁
 * 3.获取 SharedResource 角色的锁的顺序并不固定 ( SharedResource 角色是对称的)
 * 破坏其中一个条件 就可以防止死锁发生
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread, hit CTRL+C to exit.");
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        new EaterThread("Alice", spoon, fork).start();
        new EaterThread("Bobby", fork, spoon).start();
    }
}
