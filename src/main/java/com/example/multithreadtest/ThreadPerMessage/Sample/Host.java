package com.example.multithreadtest.ThreadPerMessage.Sample;

/**
 * java.lang.Thread版 & java.lang.Runnable版
 */
public class Host {
    private final Helper helper = new Helper();

    // 匿名内部类的run方法使用了request方法的参数count和c
    // 当匿名内部类用到方法的参数或局部变量时 这些变量就必须声明为final 否则程序将会出现编译错误
    public void request(final int count, final char c) {
        System.out.println("    request(" + count + ", " + c + ") BEGIN");
        // 匿名内部类 类的声明和实例的创建写在一起 -> new Thread()
        // 匿名内部类并不是在方法执行时生成类文件 而是与一般的类一样 在编译时生成类文件
        new Thread(
                () -> helper.handle(count, c)
        ).start();

//        // replaced with lambda之后同上
//        // java.lang.Thread版
//        new Thread() {
//            public void run() {
//                helper.handle(count, c);
//            }
//        }.start();
//
//        // java.lang.Runnable版
//        new Thread(
//                new Runnable() {
//                    public void run() {
//                        helper.handle(count, c);
//                    }
//                }
//        ).start();

        System.out.println("    request(" + count + ", " + c + ") END");
    }
}
