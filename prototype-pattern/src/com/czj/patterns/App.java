package com.czj.patterns;

/**
 * 运行效果
 */
public class App {

    public static void main(String[] args) {

        Prototype cp = new Prototype();
        for(int i = 0; i < 10; i++){
            Prototype cloneCp = (Prototype) cp.clone();
            cloneCp.print();
        }
    }
}
