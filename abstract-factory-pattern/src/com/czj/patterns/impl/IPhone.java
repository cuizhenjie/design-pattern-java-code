package com.czj.patterns.impl;

import com.czj.patterns.base.Phone;

/**
 * iphone手机
 *
 * @author czj
 */
public class IPhone implements Phone {

    @Override
    public void call() {
        System.out.println("使用 iphone 手机拨打电话");
    }
}
