package com.example.multithreadtest.Immutable.Sample;

/**
 * 类的字段值不会改变 因此类内方法无需注明synchronized也是线程安全的
 */
// Person类声明为了final类 是防止子类修改其字段值的一种措施
public final class Person {
    // 字段的可见性都为private 是防止子类修改其字段值的一种措施
    // 字段被声明为final 意即一旦字段被赋值 就不会再被赋值
    private final String name;
    private final String address;

    // Person类的字段值仅可通过构造函数来设置
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // 类中设有引用字段值的getter方法 但并没有修改字段值的setter方法
    // 因此 Person类的实例一旦创建 其字段的值就不会发生改变
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "[ Person: name = " + name + ", address = " + address + " ]";
    }
}
