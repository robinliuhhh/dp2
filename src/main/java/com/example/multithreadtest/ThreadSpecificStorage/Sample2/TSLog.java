package com.example.multithreadtest.ThreadSpecificStorage.Sample2;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * TSObject
 *
 * Sample1中的 Log 类中只有静态字段和静态方法 也就是说 它是以“只有一个日志文件”为前提设计而成的
 * 由于现在需要为每个线程都创建一个 TSLog 类的实例
 * 1.所以需要将静态字段和静态方法修改为实例字段和实例方法
 * 2.还需要将static代码块中的初始化处理移至构造函数中进行
 */
public class TSLog {
    private PrintWriter writer = null;

    // 初始化writer字段
    public TSLog(String filename) {
        try {
            writer = new PrintWriter(new FileWriter(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 写日志
    public void println(String s) {
        writer.println(s);
    }

    // 关闭日志
    public void close() {
        writer.println("==== End of log ====");
        writer.close();
    }
}
