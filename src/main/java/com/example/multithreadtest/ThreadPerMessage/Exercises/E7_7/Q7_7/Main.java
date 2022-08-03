package com.example.multithreadtest.ThreadPerMessage.Exercises.E7_7.Q7_7;

/**
 * 请编写Blackhole.enter(obj)方法内部的magic(obj)方法 使Main输出如下
 *  BEGIN
 *  Step 1
 *  Step 2 -> 程序停在此处不动
 */
public class Main {
    public static void main(String args[]) {
        System.out.println("BEGIN");
        Object obj = new Object();
        Blackhole.enter(obj);
        System.out.println("END");
    }
}
