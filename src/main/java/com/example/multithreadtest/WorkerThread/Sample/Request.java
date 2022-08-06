package com.example.multithreadtest.WorkerThread.Sample;

import java.util.Random;

public class Request {
    private final String name; // 委托者
    private final int number;  // 请求的编号
    private static final Random random = new Random();

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute() {
        // 字符串和实例通过+运算符连接时 自动调用实例的toString()
        // 此处this指代当前Request对象 因为WorkerThread是通过先获取Request实例再调用execute()的
        System.out.println(Thread.currentThread().getName() + " executes " + this);
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
        }
    }

    public String toString() {
        return "[ Request from " + name + " No." + number + " ]";
    }
}
