package com.cs.designpatterns.singleton;

/**
 * 懒汉式（线程不安全）
 *
 * 延迟创建实例对象
 * 提供静态方法，获取这个实例对象
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
