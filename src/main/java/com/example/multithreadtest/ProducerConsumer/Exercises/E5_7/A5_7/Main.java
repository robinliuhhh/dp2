package com.example.multithreadtest.ProducerConsumer.Exercises.E5_7.A5_7;

public class Main {
    public static void main(String[] args) {
        // 执行Host的繁重处理的线程
        Thread executor = new Thread() {
            public void run() {
                System.out.println("Host.execute BEGIN");
                try {
                    Host.execute(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Host.execute END");
            }
        };

        // main启动新线程
        // 新线程执行Host.execute()
        executor.start();

        // main线程休眠约15秒
        // 此时新线程执行完第一次doHeavyJob 第二次doHeavyJob执行了5s
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
        }

        // main线程interrupt新线程
        // Host.execute()会抛出InterruptedException 新线程终止
        // main线程进入catch 最后执行打印Host.execute END main线程终止
        System.out.println("***** interrupt *****");
        executor.interrupt();
    }
}
