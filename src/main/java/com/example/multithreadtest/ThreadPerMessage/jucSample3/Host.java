package com.example.multithreadtest.ThreadPerMessage.jucSample3;

import java.util.concurrent.Executor;

/**
 * java.util.concurrent.ExecutorService版
 * 将被复用的线程抽象化
 */
public class Host {
    private final Helper helper = new Helper();
    private final Executor executor;

    public Host(Executor executor) {
        this.executor = executor;
    }

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        executor.execute(
                () -> helper.handle(count, c)
        );
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
