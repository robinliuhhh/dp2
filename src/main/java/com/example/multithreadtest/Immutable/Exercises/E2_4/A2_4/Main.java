package com.example.multithreadtest.Immutable.Exercises.E2_4.A2_4;

import com.example.multithreadtest.Immutable.Exercises.E2_4.Q2_4.UserInfo;

/**
 * 解释
 *
 * 由于info字段声明为了final 所以info字段的值本身（指向的实例 指位置）并不会改变
 * info字段所指向的实例的状态（字符串内容）却有可能改变
 */
public class Main {
    public static void main(String[] args) {
        UserInfo userinfo = new UserInfo("Alice", "Alaska");

        System.out.println("userinfo = " + userinfo);

        // 修改状态
        StringBuffer info = userinfo.getInfo();
        // String类的replace方法并不会修改实例本身 StringBuffer类的replace方法会修改实例本身
        // 这是因为StringBuffer类是mutable类
        StringBuffer bobby = info.replace(12, 17, "Bobby");

        System.out.println(info.hashCode() == bobby.hashCode() ? "yes" : "no");

        System.out.println("userinfo = " + userinfo);
    }
}
