package com.example.multithreadtest.SingleThreadedExecution.Exercises.E1_6.A1_6.a;

import com.example.multithreadtest.SingleThreadedExecution.Exercises.E1_6.Q1_6.EaterThread;
import com.example.multithreadtest.SingleThreadedExecution.Exercises.E1_6.Q1_6.Tool;

/**
 * 思路
 *
 * 破坏条件：SharedResource 角色是对称的
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread, hit CTRL+C to exit.");
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        // Alice 和 Bobby 以相同顺序拿取餐具
        new EaterThread("Alice", spoon, fork).start();
        new EaterThread("Bobby", spoon, fork).start();
    }
}
