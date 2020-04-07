package com.czj.patterns.impl;


import com.czj.patterns.base.AbstractFactory;
import com.czj.patterns.base.Pad;
import com.czj.patterns.base.Phone;

/**
 * 具体工厂：苹果工厂
 *
 * @author czj
 */
public class AppleFactory extends AbstractFactory {

    @Override
    public Pad createPad() {
        System.out.println(">>>>>>生产苹果pad");

        return new ApplePad();
    }

    @Override
    public Phone createPhone() {
        System.out.println(">>>>>>生产iphone");

        return new IPhone();
    }
}
