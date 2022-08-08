package com.example.multithreadtest.TwoPhaseTermination.Sample;

public class CountupThread extends Thread {
    // 计数值
    private long counter = 0;

    // volatile: shutdownRequest被调用后 shutdownRequested值的变化直接刷入内存
    // 其他方法读到的shutdownRequested值始终是最新的
    private volatile boolean shutdownRequested = false;

    // 终止请求
    // 该方法无需设置为synchronized
    // 因为shutdownRequested标志是一个一旦被设置为true后就不会再变为false的闭锁 即使它被多个线程同时调用也不会有问题
    // 也就是说设置为true的线程和设置为false的线程不存在数据竞争
    public void shutdownRequest() {
        shutdownRequested = true;
        // 为了确保线程在sleep或wait时也会被终止 提高程序响应性
        interrupt();
    }

    // 检查是否发出了终止请求
    public boolean isShutdownRequested() {
        return shutdownRequested;
    }

    // 线程体
    public final void run() {
        try {
            while (!isShutdownRequested()) {
                doWork();
            }
        } catch (InterruptedException e) {
        } finally {
            // 确保在抛出异常后程序也会执行终止处理
            doShutdown();
        }
    }

    // 操作
    private void doWork() throws InterruptedException {
        counter++;
        System.out.println("doWork: counter = " + counter);
        Thread.sleep(500);
    }

    // 终止处理
    private void doShutdown() {
        System.out.println("doShutdown: counter = " + counter);
    }
}
