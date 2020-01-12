package com.cs.design_patterns.singleton;

/**
 * 懒汉式（线程安全）
 *
 * 延迟创建实例对象
 * 提供静态方法，获取这个实例对象
 */
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {

    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
