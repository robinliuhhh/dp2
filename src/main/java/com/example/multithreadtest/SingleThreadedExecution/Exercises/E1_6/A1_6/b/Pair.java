package com.example.multithreadtest.SingleThreadedExecution.Exercises.E1_6.A1_6.b;

import com.example.multithreadtest.SingleThreadedExecution.Exercises.E1_6.Q1_6.Tool;

public class Pair {
    private final Tool lefthand;
    private final Tool righthand;

    public Pair(Tool lefthand, Tool righthand) {
        this.lefthand = lefthand;
        this.righthand = righthand;
    }

    public String toString() {
        return "[ " + lefthand + " and " + righthand + " ]";
    }
}
