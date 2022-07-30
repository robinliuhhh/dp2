package com.example.multithreadtest.Immutable.jucSample2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * java.util.ArrayList 是非线程安全的类
 * 但如果使用 Collections.synchronizedList 方法进行同步 就能够得到线程安全的实例
 *
 * 适合写多读少场景
 */
public class Main {
    public static void main(String[] args) {
        // Collections.synchronizedList()是一个方法
        final List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }

    // output
    // 并未抛出 ConcurrentModificationException 和 NullPointerException 异常
    // 但是编号是跳跃的 这是因为在 ReaderThread 读取之前 WriteThread 不断改写了其值
}
