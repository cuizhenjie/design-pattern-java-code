package com.czj.patterns.base;

/**
 * 抽象工厂类
 *
 * @author czj
 */
public abstract class AbstractFactory {

    /**
     * 生产pad
     *
     * @return
     */
    public abstract Pad createPad();

    /**
     * 生产phone
     *
     * @return
     */
    public abstract Phone createPhone();
}
