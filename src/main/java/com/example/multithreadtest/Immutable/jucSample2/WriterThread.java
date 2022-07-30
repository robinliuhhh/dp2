package com.example.multithreadtest.Immutable.jucSample2;

import java.util.List;

public class WriterThread extends Thread {
    private final List<Integer> list;

    public WriterThread(List<Integer> list) {
        super("WriterThread");
        this.list = list;
    }

    public void run() {
        for (int i = 0; true; i++) {
            // 查看Collections.synchronizedList()源码
            // add 和 remove 已被声明为synchronized方法 这里可以直接使用
            list.add(i);
            list.remove(0);
        }
    }
}
