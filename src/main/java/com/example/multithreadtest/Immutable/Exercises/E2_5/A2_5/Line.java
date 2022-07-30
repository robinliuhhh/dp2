package com.example.multithreadtest.Immutable.Exercises.E2_5.A2_5;

public class Line {
    private final Point startPoint;
    private final Point endPoint;

    public Line(int startx, int starty, int endx, int endy) {
        this.startPoint = new Point(startx, starty);
        this.endPoint = new Point(endx, endy);
    }

    // 没有直接使用参数中传入的实例
    // 而是建了一个与传入实例的内容相同的新实例 并将该新实例赋给了字段
    // 此时startPoint指向的地址和传入参数的地址不同 不会产生联动修改
    public Line(Point startPoint, Point endPoint) {
        this.startPoint = new Point(startPoint.x, startPoint.y);
        this.endPoint = new Point(endPoint.x, endPoint.y);
    }

    public int getStartX() {
        return startPoint.x;
    }

    public int getStartY() {
        return startPoint.y;
    }

    public int getEndX() {
        return endPoint.x;
    }

    public int getEndY() {
        return endPoint.y;
    }

    public String toString() {
        return "[ Line: " + startPoint + "-" + endPoint + " ]";
    }
}
