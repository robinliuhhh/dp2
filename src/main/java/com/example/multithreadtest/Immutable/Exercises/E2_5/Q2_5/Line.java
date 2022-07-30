package com.example.multithreadtest.Immutable.Exercises.E2_5.Q2_5;

/**
 * 问题描述
 *
 * 判断是否是immutable类
 */
public class Line {
    private final Point startPoint;
    private final Point endPoint;

    public Line(int startx, int starty, int endx, int endy) {
        this.startPoint = new Point(startx, starty);
        this.endPoint = new Point(endx, endy);
    }

    // 实例直接赋值给字段 Line和Point持有同一个实例的索引
    // 虽然Line字段声明为final 但是指向的Point实例内容却可能发生改变
    // 例如：startPoint指向一号柜 里面存放红色球 红色球有可能被替换成绿色球 但startPoint指向的一号柜不变
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getStartX() {
        return startPoint.getX();
    }

    public int getStartY() {
        return startPoint.getY();
    }

    public int getEndX() {
        return endPoint.getX();
    }

    public int getEndY() {
        return endPoint.getY();
    }

    public String toString() {
        return "[ Line: " + startPoint + "-" + endPoint + " ]";
    }
}
