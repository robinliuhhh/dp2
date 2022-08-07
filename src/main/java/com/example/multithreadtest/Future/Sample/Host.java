package com.example.multithreadtest.Future.Sample;

/**
 * 虽然此类的request方法并非synchronized 但依然可以被多个线程安全调用
 * 因为此类不含任何字段（即不带有任何状态） 即使多个线程访问也不会破坏安全性
 */
public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) 创建FutureData的实例
        final FutureData future = new FutureData();

        // (2) 启动一个新线程，用于创建RealData的实例
        new Thread(() -> {
            RealData realdata = new RealData(count, c);
            future.setRealData(realdata);
        }).start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) 返回FutureData的实例
        return future;
    }
}
