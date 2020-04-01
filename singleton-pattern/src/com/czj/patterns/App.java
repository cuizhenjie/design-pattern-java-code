package com.czj.patterns;

/**
 * 运行效果
 * @author czj
 */
public class App {

    public static void main(String[] args) {

        // 方式1，懒汉式 + 双重检验锁
        com.czj.patterns.realizetion1.Singleton singleton1 = com.czj.patterns.realizetion1.Singleton.getInstance();

        // 方式2，静态内部类
        com.czj.patterns.realizetion2.Singleton singleton2 = com.czj.patterns.realizetion2.Singleton.getInstance();

    }
}
