package com.czj.patterns;

/**
 * 演示类
 *
 * @author czj
 */
public class App {

    public static void main(String[] args) {
        Computer computer = new Computer.Builder("三星屏", "Android 原生 OS")
                .isBluetoothEnabled(true)
                .builder();

        System.out.println(computer.toString());
    }
}
