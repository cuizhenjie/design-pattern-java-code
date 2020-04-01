package com.czj.patterns;

import com.czj.patterns.base.Factory;
import com.czj.patterns.base.Operation;

/**
 * 运行效果类
 *
 * @author czj
 */
public class App {

    public static void main(String[] args) {

        Operation addOperation = Factory.createInstance("+");
        Operation minusOperation = Factory.createInstance("-");
        Operation multiplyOperation = Factory.createInstance("*");
        Operation divideOperation = Factory.createInstance("/");

        System.out.println(addOperation.compute(2, 2));
        System.out.println(minusOperation.compute(2, 2));
        System.out.println(multiplyOperation.compute(2, 2));
        System.out.println(divideOperation.compute(2, 2));

    }
}
