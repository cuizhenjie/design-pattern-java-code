package com.czj.patterns.impl;

import com.czj.patterns.base.Operation;

/**
 * 除操作实现类
 *
 * @author czj
 */
public class DivideOperation implements Operation {

    @Override
    public int compute(int value1, int value2) {
        if(value2 == 0) {
            throw new RuntimeException("除数不能为0");
        }
        return value1 / value2;
    }

}
