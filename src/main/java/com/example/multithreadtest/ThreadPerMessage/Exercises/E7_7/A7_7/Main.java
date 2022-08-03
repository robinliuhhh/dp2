package com.example.multithreadtest.ThreadPerMessage.Exercises.E7_7.A7_7;

public class Main {
    public static void main(String args[]) {
        System.out.println("BEGIN");
        Object obj = new Object();
        Blackhole.enter(obj);
        System.out.println("END");
    }
}
