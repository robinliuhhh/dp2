package com.example.multithreadtest.Immutable.jucSample2;

import java.util.List;

public class ReaderThread extends Thread {
    private final List<Integer> list;

    public ReaderThread(List<Integer> list) {
        super("ReaderThread");
        this.list = list;
    }

    public void run() {
        while (true) {
            // 查看Collections.synchronizedList()源码
            // listIterator 没声明为synchronized方法 需要我们手动添加
            synchronized (list) {
                // 隐式使用Iterator
                for (int n : list) {
                    System.out.println(n);
                }
            }
        }
    }
}
