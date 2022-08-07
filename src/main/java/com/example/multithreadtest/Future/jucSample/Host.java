package com.example.multithreadtest.Future.jucSample;

import java.util.concurrent.Callable;

public class Host {
    public FutureData request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        // (1) 创建FutureData的实例
        //     （向构造函数中传递 Callable<RealData>）
//        FutureData future = new FutureData(
//                new Callable<RealData>() {
//                    public RealData call() {
//                        return new RealData(count, c);
//                    }
//                }
//        );
        FutureData future = new FutureData(
                () -> new RealData(count, c)
        );

        // (2) 启动一个新线程，用于创建RealData的实例
        // 新线程会调用Callable的call方法 然后set返回值RealData的实例给future对象
        new Thread(future).start();

        System.out.println("    request(" + count + ", " + c + ") END");

        // (3) 返回FutureData的实例
        return future;
    }
}
