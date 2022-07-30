package com.example.multithreadtest.Immutable.Exercises.E2_5.Q2_5;

/**
 * 测试修改Line状态
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("test mutable");

        // 创建实例 mutable
        Point p1 = new Point(0, 0);
        Point p2 = new Point(100, 0);
        Line line = new Line(p1, p2);

        // 显示
        System.out.println("line = " + line);

        // 修改状态
        p1.x = 150;
        p2.x = 150;
        p2.y = 250;

        // 再次显示
        System.out.println("line = " + line);
    }
}
