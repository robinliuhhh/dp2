package com.example.multithreadtest.ThreadSpecificStorage.Sample1;

/**
 * 单线程程序 不使用Thread-Specific Storage模式
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("BEGIN");
        for (int i = 0; i < 10; i++) {
            Log.println("main: i = " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        Log.close();
        System.out.println("END");
    }
}
