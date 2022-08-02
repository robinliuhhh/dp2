package com.example.multithreadtest.ReadWriteLock.Sample;

/**
 * preferWriter字段的作用
 *
 *  防止线程总是读 或 写
 *  在readUnlock和writeUnlock操作之后更新读写优先级
 *  read操作终止后优先执行write操作 write作终止后优先执行read操作
 *  由此可以使ReaderThread和WriterThread轮流优先执行
 */
public final class ReadWriteLock {
    private int readingReaders = 0; // (A)…实际正在读取中的线程个数
    private int waitingWriters = 0; // (B)…正在等待写入的线程个数
    private int writingWriters = 0; // (C)…实际正在写入中的线程个数
    private boolean preferWriter = true; // 若写入优先，则为true

    public synchronized void readLock() throws InterruptedException {
        while (writingWriters > 0 || (preferWriter && waitingWriters > 0)) {
            wait();
        }
        readingReaders++;                       // (A) 实际正在读取的线程个数加1
    }

    public synchronized void readUnlock() {
        readingReaders--;                       // (A) 实际正在读取的线程个数减1
        preferWriter = true;
        notifyAll();
    }

    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;                       // (B) 正在等待写入的线程个数加1
        try {
            while (readingReaders > 0 || writingWriters > 0) {
                wait();
            }
        } finally {
            waitingWriters--;                   // (B) 正在等待写入的线程个数减1
        }
        writingWriters++;                       // (C) 实际正在写入的线程个数加1
    }

    public synchronized void writeUnlock() {
        writingWriters--;                       // (C) 实际正在写入的线程个数减1
        preferWriter = false;
        notifyAll();
    }
}
