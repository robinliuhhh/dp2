package com.example.multithreadtest.Future.Exercises.E9_4.A9_4a;

/**
 * 思路
 *
 * 程序在创建RealData的实例时发生了NegativeArraySizeException异常 所以先找出哪里调用了RealData的构造方法
 * 1.try-catch处理调用了RealData的构造方法的代码
 * 2.catch块中 将异常传递给FutureData类
 * 3.FutureData类的getContent抛出此异常 这样主线程在调用getContent方法时就能感知到此异常了
 */
public class Host {
    public Data request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");

        final FutureData future = new FutureData();

        new Thread(() -> {
            // try-catch处理调用了RealData的构造方法的代码
            try {
                RealData realdata = new RealData(count, c);
                future.setRealData(realdata);
            } catch (Exception e) {
                // 将异常传递给FutureData类
                future.setException(e);
            }
        }).start();

        System.out.println("    request(" + count + ", " + c + ") END");

        return future;
    }
}
