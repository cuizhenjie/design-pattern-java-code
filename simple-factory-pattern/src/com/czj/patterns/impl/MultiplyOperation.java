package com.czj.patterns.impl;

import com.czj.patterns.base.Operation;

/**
 * 乘操作实现类
 *
 * @author czj
 */
public class MultiplyOperation implements Operation {

    @Override
    public int compute(int value1, int value2) {
        return value1 * value2;
    }

}
