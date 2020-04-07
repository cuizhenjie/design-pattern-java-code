package com.czj.patterns.impl;

import com.czj.patterns.base.Phone;

/**
 * 小米手机
 *
 * @author czj
 */
public class MiPhone implements Phone {

    @Override
    public void call() {
        System.out.println("使用 小米手机拨打电话");
    }
}
