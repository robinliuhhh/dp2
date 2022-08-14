package com.example.multithreadtest.ThreadSpecificStorage.Sample2;

/**
 * 使用Thread-Specific Storage模式
 *
 * TSObjectProxy 角色使用 TSObjectCollection 角色获取与当前线程对应的 TSObject 角色
 * 并将处理委托给该 TSObject 角色
 */
public class Main {
    public static void main(String[] args) {
        // 不同的线程将字符串写入不同的日志文件中

        // 虽然这3个线程调用的是 Log 类的同一个方法
        // 但是实际上它们使用的却是各个线程特有的 TSLog 的实例
        new ClientThread("Alice").start();
        new ClientThread("Bobby").start();
        new ClientThread("Chris").start();
    }
}
