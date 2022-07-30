package com.example.multithreadtest.Immutable.Sample;

/**
 * 测试使用Immutable模式的Person类
 */
public class Main {
    public static void main(String[] args) {
        Person alice = new Person("Alice", "Alaska");
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
        new PrintPersonThread(alice).start();
    }
}
