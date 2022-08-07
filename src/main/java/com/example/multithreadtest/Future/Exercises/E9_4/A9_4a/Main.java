package com.example.multithreadtest.Future.Exercises.E9_4.A9_4a;

/**
 * 问题描述
 *
 * 程序在创建RealData的实例时发生了NegativeArraySizeException异常
 * 该异常是从request方法启动的新线程中被抛出的
 * 也就是说 try-catch处理request方法和getContent方法并不能捕获该异常
 * 所以当新线程抛出NegativeArraySizeException异常时 主线程感知不到 因此一直在getContent方法中wait
 *
 * 修改程序 使getContent方法能感知到此异常
 */
public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("main BEGIN");
            Host host = new Host();

            // 抛出java.lang.NegativeArraySizeException异常
            Data data = host.request(-1, 'N');

            System.out.println("data = " + data.getContent());

            System.out.println("main END");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
