package com.example.multithreadtest.SingleThreadedExecution.Exercises.E1_6.A1_6.b;

import com.example.multithreadtest.SingleThreadedExecution.Exercises.E1_6.Q1_6.Tool;

/**
 * 思路
 *
 * 破坏条件：存在多个 SharedResource 角色
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread, hit CTRL+C to exit.");
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        // 勺子和叉子成对拿取
        Pair pair = new Pair(spoon, fork);
        new EaterThread("Alice", pair).start();
        new EaterThread("Bobby", pair).start();
    }
}
