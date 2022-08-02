package com.example.multithreadtest.ReadWriteLock.Sample;

/**
 * SharedResource
 * 提供了read、write两个操作 read操作不会改变SharedResource角色的状态 write操作则会改变其状态
 */
public class Data {
    private final char[] buffer;
    private final ReadWriteLock lock = new ReadWriteLock();

    // 构造函数会根据参数传入的长度来分配一个char数组
    // 并初始化buffer字段 以字符*填满buffer
    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = '*';
        }
    }

    public char[] read() throws InterruptedException {
        lock.readLock();
        // 当在try块或catch块中遇到return语句时 finally语句块将在方法返回之前被执行
        // 不要在finally语句块中使用return
        //  当try语句和finally语句中都有return语句时 try语句块中的return语句会被忽略
        //  这是因为try语句中的return返回值会先被暂存在一个本地变量中
        //  当执行到finally语句中的return之后 这个本地变量的值就变为了finally语句中的return返回值
        try {
            // 保护的是buffer字段
            return doRead();
        } finally {
            lock.readUnlock();
        }
    }

    public void write(char c) throws InterruptedException {
        lock.writeLock();
        try {
            // 保护的是buffer字段
            doWrite(c);
        } finally {
            lock.writeUnlock();
        }
    }

    private char[] doRead() {
        char[] newbuf = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newbuf[i] = buffer[i];
        }
        slowly();
        return newbuf;
    }

    private void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly();
        }
    }

    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
        }
    }
}
