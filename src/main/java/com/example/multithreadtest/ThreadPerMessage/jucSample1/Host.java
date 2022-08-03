package com.example.multithreadtest.ThreadPerMessage.jucSample1;

import java.util.concurrent.ThreadFactory;

/**
 * java.util.concurrent.ThreadFactory版
 * 将线程创建抽象化
 */
public class Host {
    private final Helper helper = new Helper();
    private final ThreadFactory threadFactory;

    public Host(ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
    }

    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        threadFactory.newThread(
                () -> helper.handle(count, c)
        ).start();
        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
