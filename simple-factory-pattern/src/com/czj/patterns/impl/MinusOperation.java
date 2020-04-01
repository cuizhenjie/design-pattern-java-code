package com.czj.patterns.impl;

import com.czj.patterns.base.Operation;

/**
 * 减操作实现类
 *
 * @author czj
 */
public class MinusOperation implements Operation {

    @Override
    public int compute(int value1, int value2) {
        return value1 - value2;
    }

}
