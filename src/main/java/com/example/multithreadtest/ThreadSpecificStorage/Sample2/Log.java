package com.example.multithreadtest.ThreadSpecificStorage.Sample2;

/**
 * TSObjectProxy 与TSObject具有相同接口
 *
 * ThreadLocal的set、get方法
 * key是作为调用方的当前线程 value是<>内的类的实例
 */
public class Log {
    // TSObjectCollection
    // 用于管理Client -> TSObject之间的对应关系
    private static final ThreadLocal<TSLog> tsLogCollection = new ThreadLocal<>();

    // 写日志
    public static void println(String s) {
        // Main.2 实际上它们使用的却是各个线程特有的 TSLog 的实例
        getTSLog().println(s);
    }

    // 关闭日志
    public static void close() {
        getTSLog().close();
    }

    // 获取线程特有的日志
    private static TSLog getTSLog() {
        TSLog tsLog = tsLogCollection.get();

        // 如果该线程是第一次调用本方法，就新生成并注册一个日志
        if (tsLog == null) {
            tsLog = new TSLog(Thread.currentThread().getName() + "-log.txt");
            tsLogCollection.set(tsLog);
        }

        return tsLog;
    }
}
