package com.example.multithreadtest.Balking.Sample;

import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;

/**
 * GuardedObject 被守护的对象
 * synchronized保护的是content字段和changed字段
 * balk结果的表示方式 忽略 -> return; or 抛异常 -> throw
 */
public class Data {
    private final String filename;  // 保存的文件名称
    private String content;         // 数据内容
    private boolean changed;        // 内容是否被修改 修改后未保存则为true

    public Data(String filename, String content) {
        this.filename = filename;
        this.content = content;
        this.changed = true;
    }

    // StateChangingMethod 改变守护条件
    // 修改数据内容
    public synchronized void change(String newContent) {
        content = newContent;
        changed = true;
    }

    // GuardedMethod 若守护条件成立 可以立即执行 当守护条件不成立时 直接返回
    // 若数据内容修改过，则保存到文件中
    public synchronized void save() throws IOException {
        if (!changed) {
            return;
        }
        // 当FileWriter抛出异常时 程序便会跳出doSave和save方法
        // changed = false;不会被执行
        // 若此方法内执行了try-catch 线程将无法捕获异常
        // 本类是[资源文件] 建议直接抛异常 方便调用方捕获
        doSave();
        changed = false;
    }

    // 将数据内容实际保存到文件中
    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls doSave, content = " + content);
        Writer writer = new FileWriter(filename);
        writer.write(content);
        writer.close();
    }
}
