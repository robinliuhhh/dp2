package com.example.multithreadtest.ProducerConsumer.jucSample;

import java.util.concurrent.Exchanger;

/**
 * Producer -> Buffer -> Consumer
 * 使用java.util.concurrent.Exchanger类交换缓冲区
 */
public class Main {
    public static void main(String[] args) {
        Exchanger<char[]> exchanger = new Exchanger<>();
        char[] buffer1 = new char[10];
        char[] buffer2 = new char[10];
        new ProducerThread(exchanger, buffer1, 314159).start();
        new ConsumerThread(exchanger, buffer2, 265358).start();
    }
}
