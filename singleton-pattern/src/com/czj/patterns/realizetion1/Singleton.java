package com.czj.patterns.realizetion1;

/**
 * 懒汉式单例，双重检验锁
 *
 * @author czj
 */
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {

    }

    /**
     * 实例化
     *
     * @return
     */
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }
}
