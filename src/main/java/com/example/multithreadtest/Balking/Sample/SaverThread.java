package com.example.multithreadtest.Balking.Sample;

import java.io.IOException;

/**
 * 执行[自动保存]的线程
 */
public class SaverThread extends Thread {
    private final Data data;

    public SaverThread(String name, Data data) {
        super(name);
        this.data = data;
    }

    public void run() {
        try {
            while (true) {
                data.save();            // 要求保存数据
                Thread.sleep(1000);     // 休眠约1秒
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
