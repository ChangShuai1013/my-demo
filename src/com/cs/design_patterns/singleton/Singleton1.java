package com.cs.design_patterns.singleton;

/**
 * 饿汉式（在类初始化时直接创建实例对象，不管是否需要这个对象）
 *
 * 构造器私有化
 * 自行创建，并且用静态变量保存
 * 向外提供这个实例
 * 强调这是一个单例，使用final修饰
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1(){

    }
}
