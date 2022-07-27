package com.example.multithreadtest.SingleThreadedExecution.Sample;

/**
 * 角色：Shared Resource
 * 多个线程共享的字段、方法必须使用 synchronized （或者 volatile) 加以保护
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "Nowhere";

//    public void pass(String name, String address) {
    public synchronized void pass(String name, String address) {
        this.counter++;
        this.name = name;
        this.address = address;
        check();
    }

//    public String toString() {
    public synchronized String toString() {
        return "No." + counter + ": " + name + ", " + address;
    }

    // private方法 类外不可调用
    // 类内只有pass()调用 所以此方法不用声明synchronized
    private void check() {
        if (name.charAt(0) != address.charAt(0)) {
            System.out.println("***** BROKEN ***** " + toString());
        }
    }
}
