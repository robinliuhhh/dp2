package com.example.multithreadtest.ProducerConsumer.Exercises.E5_7.A5_7;

/**
 * isInterrupted是Thread类的实例方法 用于检查指定线程的中断状态
 * Thread.interrupted是Thread类的静态方法 用于检查井清除当前线程的中断状态
 */
public class Host {
    public static void execute(int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            // 检测到当前线程为中断状态 当前线程会抛出异常并终止
            // 第三次for循环时检测到中断状态 此时抛出异常
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            // Main类执行executor.interrupt();时 第二次doHeavyJob执行了5s
            // 执行完doHeavyJob();后 进行新一轮for循环时 才检测到中断状态
            doHeavyJob();
        }
    }

    private static void doHeavyJob() {
        // 下面代码用于表示"无法取消的繁重处理"（循环处理约10秒）
        System.out.println("doHeavyJob BEGIN");
        long start = System.currentTimeMillis();
        while (start + 10000 > System.currentTimeMillis()) {
            // busy loop
        }
        System.out.println("doHeavyJob END");
    }
}
