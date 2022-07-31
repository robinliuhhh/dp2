package com.example.multithreadtest.Balking.InitSample;

/**
 * Balking模式之守护条件仅在第一次成立
 */
public class Something {
    // 像initialized字段这样“状态仅变化一次的变量” 我们通常称为闭锁(latch 门闩)
    // 这个门闩一旦插上 就再也打不开了
    private boolean initialized = false;

    public synchronized void init() {
        if (initialized) {
            return;
        }
        doInit();
        initialized = true;
    }

    private void doInit() {
        // 实际的初始化处理
    }
}
