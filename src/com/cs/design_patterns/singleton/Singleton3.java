package com.cs.design_patterns.singleton;

/**
 * 饿汉式（静态代码块）
 *
 * 适合复杂实例化
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;

    static {
        //可以在此处加载配置文件等
        INSTANCE = new Singleton3();
    }

    private Singleton3() {

    }
}
