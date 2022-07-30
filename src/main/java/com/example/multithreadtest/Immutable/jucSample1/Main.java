package com.example.multithreadtest.Immutable.jucSample1;

import java.util.List;
import java.util.ArrayList;

/**
 * java.util.ArrayList 是非线程安全的类
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // ArrayList类在被多个线程同时读写而失去安全性时
        // 会抛出 ConcurrentModificationException / NullPointerException 异常
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }
}
