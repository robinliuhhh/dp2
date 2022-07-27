package com.example.multithreadtest.SingleThreadedExecution.Exercises.E1_1.Q1_1;

/**
 * 问题描述
 *
 * 检查出第一个错误的时候 counter字段的值已经变得很大
 * 也就是说 在检查出第一个错误时 gate.pass()方法执行了很多次
 * 请试着修改一下Gate类 使其在counter值很小时就能够检查出错误
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing Gate, hit CTRL+C to exit.");
        Gate gate = new Gate();
        new UserThread(gate, "Alice", "Alaska").start();
        new UserThread(gate, "Bobby", "Brazil").start();
        new UserThread(gate, "Chris", "Canada").start();
    }
}
