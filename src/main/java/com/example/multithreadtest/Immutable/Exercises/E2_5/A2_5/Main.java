package com.example.multithreadtest.Immutable.Exercises.E2_5.A2_5;

public class Main {
    public static void main(String[] args) {
        System.out.println("test immutable");

        // 创建实例 immutable
        Point p1 = new Point(0, 0);
        Point p2 = new Point(100, 0);
        Line line = new Line(p1, p2);

        // 显示
        System.out.println("line = " + line);

        // 修改状态
        // 若将Point类字段修改为public final
        // 此处报错：Cannot assign a value to final variable
        // 也实现了immutable
        p1.x = 150;
        p2.x = 150;
        p2.y = 250;

        // 再次显示
        System.out.println("line = " + line);
    }
}
