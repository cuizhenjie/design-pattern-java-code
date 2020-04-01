package com.czj.patterns.base;

import com.czj.patterns.impl.AddOperation;
import com.czj.patterns.impl.DivideOperation;
import com.czj.patterns.impl.MinusOperation;
import com.czj.patterns.impl.MultiplyOperation;

/**
 * 工厂类
 *
 * @author czj
 */
public class Factory {

    public static Operation createInstance(String symbol) {

        Operation instance = null;
        switch (symbol) {
            case "+":
                instance = new AddOperation();
                break;
            case "-":
                instance = new MinusOperation();
                break;
            case "*":
                instance = new MultiplyOperation();
                break;
            case "/":
                instance = new DivideOperation();
                break;
        }

        return instance;
    }

}
