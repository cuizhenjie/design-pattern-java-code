package com.czj.patterns.impl;


import com.czj.patterns.base.AbstractFactory;
import com.czj.patterns.base.Pad;
import com.czj.patterns.base.Phone;

/**
 * 具体工厂：小米工厂
 *
 * @author czj
 */
public class MiFactory extends AbstractFactory {

    @Override
    public Pad createPad() {
        System.out.println(">>>>>>生产小米pad");

        return new MiPad();
    }

    @Override
    public Phone createPhone() {
        System.out.println(">>>>>>生产小米手机");

        return new MiPhone();
    }

}
