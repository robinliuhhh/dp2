package com.example.multithreadtest.Immutable.Sample;

public class PrintPersonThread extends Thread {
    private Person person;

    public PrintPersonThread(Person person) {
        this.person = person;
    }

    public void run() {
        while (true) {
            // 字符串和实例通过+运算符连接时 自动调用实例的toString()
            System.out.println(Thread.currentThread().getName() + " prints " + person);
        }
    }
}
