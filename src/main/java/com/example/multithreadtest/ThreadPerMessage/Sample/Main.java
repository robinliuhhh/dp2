package com.example.multithreadtest.ThreadPerMessage.Sample;

/**
 * Client -> Host -> Helper
 * Main类委托Host类来显示字符
 * Host类会创建并启动一个线程来处理该委托
 * 启动的线程使用Helper类来执行实际的显示
 *
 *
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host();
        host.request(10, 'A');
        host.request(20, 'B');
        host.request(30, 'C');
        System.out.println("main END");
    }

    // output
    /*
        main BEGIN
            request(10, A) BEGIN
            request(10, A) END
            request(20, B) BEGIN
            request(20, B) END
            request(30, C) BEGIN
            request(30, C) END
        main END
                handle(20, B) BEGIN
                handle(10, A) BEGIN
                handle(30, C) BEGIN
        BCACBABACBCABCAABCCBAABCBCABCA
                handle(10, A) END
        CBCBBCBCCBCBCBCBCBCB
                handle(20, B) END
        CCCCCCCCCC
                handle(30, C) END
     */
}
