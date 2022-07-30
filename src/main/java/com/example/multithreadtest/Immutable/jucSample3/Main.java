package com.example.multithreadtest.Immutable.jucSample3;

import com.example.multithreadtest.Immutable.jucSample1.ReaderThread;
import com.example.multithreadtest.Immutable.jucSample1.WriterThread;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * java.util.concurrent.CopyOnWriteArrayList 是线程安全的类
 * 采用 copy-on-write 技术来避免读写冲突
 * copy-on-write：add元素时复制一个副本 对副本加可重入锁再写 然后修改引用 最后解锁
 *
 * 适合读多写少场景
 */
public class Main {
    public static void main(String[] args) {
        final List<Integer> list = new CopyOnWriteArrayList<>();
        new WriterThread(list).start();
        new ReaderThread(list).start();
    }

    // output
    // 同jucSample2
}
