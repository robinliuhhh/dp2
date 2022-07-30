package com.example.multithreadtest.Immutable.Exercises.E2_4.Q2_4;

/**
 * 问题描述
 *
 * 明明没有setter方法 却不是immutable类
 */
public final class UserInfo {
    // StringBuffer虽然声明为final 但StringBuffer本身会修改自己的内容
    private final StringBuffer info;

    public UserInfo(String name, String address) {
        this.info = new StringBuffer("<info name=\"" + name + "\" address=\"" + address + "\" />");
    }

    public StringBuffer getInfo() {
        return info;
    }

    public String toString() {
        return "[ UserInfo: " + info + " ]";
    }
}
