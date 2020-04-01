package com.czj.patterns.realizetion2;

/**
 * 静态内部类方式
 *
 * @author czj
 */
public class Singleton {

    private Singleton() {}

    public static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

}
