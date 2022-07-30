package com.example.multithreadtest.Immutable.Exercises.E2_5.Q2_5;

public class Point {
    // 字段都是public 且不是final 所以这两个字段的值可以随意改写
    // 因此 Point类是mutable类
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
