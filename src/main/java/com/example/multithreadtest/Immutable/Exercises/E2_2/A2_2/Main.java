package com.example.multithreadtest.Immutable.Exercises.E2_2.A2_2;

/**
 * 解释
 *
 * replace方法会新建一个实例 用来保存替换后的字符串中的字符 并将该例作为返回值
 * 但变量s中保存的实例内容并没有被改写
 */
public class Main {
    public static void main(String[] args) {
        String s = "BAT";
        String t = s.replace('B', 'C'); // 将'B'替换为'C'
        System.out.println("s = " + s); // 执行replace后的s
        System.out.println("t = " + t); // replace的返回值t
        if (s.equals(t)) {
            System.out.println("s == t");
        } else {
            System.out.println("s != t");
        }
    }
}
