package com.example.multithreadtest.ThreadPerMessage.jucSample2;

import java.util.concurrent.Executor;

/**
 * java.util.concurrent.Executor版
 * 将线程执行抽象化
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
