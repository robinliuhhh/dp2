package com.example.multithreadtest.Balking.Sample;

/**
 * 文档自动保存功能的超级精简版
 */
public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "(empty)");
        new ChangerThread("ChangerThread", data).start();
        new SaverThread("SaverThread", data).start();
    }

    // output
    // 没有重复的编号
    // 因为当content相同时 线程就会balk 不再调用doSave方法
}
