package com.czj.patterns;

import com.czj.patterns.base.AbstractFactory;
import com.czj.patterns.base.Pad;
import com.czj.patterns.base.Phone;
import com.czj.patterns.impl.AppleFactory;
import com.czj.patterns.impl.MiFactory;

/**
 * 运行类
 *
 * @author czj
 */
public class App {

    public static void main(String[] args) {

        // 小米工厂
        AbstractFactory miFactory = new MiFactory();

        Pad miPad = miFactory.createPad();
        miPad.playGame();

        Phone miPhone = miFactory.createPhone();
        miPhone.call();


        // 苹果工厂
        AbstractFactory appleFactory = new AppleFactory();

        Pad iPad = appleFactory.createPad();
        iPad.playGame();

        Phone iPhone = appleFactory.createPhone();
        iPhone.call();
    }

}
