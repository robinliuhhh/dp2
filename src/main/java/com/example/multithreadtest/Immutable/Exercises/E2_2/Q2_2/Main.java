package com.example.multithreadtest.Immutable.Exercises.E2_2.Q2_2;

/**
 * 问题描述
 *
 * replace方法修改了String的值 String类还是Immutable模式吗
 */
public class Main {
    public static void main(String[] args) {
        String s = "BAT";
        System.out.println(s.replace('B', 'C')); // 将'B'替换为'C'
    }
}
