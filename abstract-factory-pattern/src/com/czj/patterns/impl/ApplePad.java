package com.czj.patterns.impl;

import com.czj.patterns.base.Pad;

/**
 * 苹果pad
 *
 * @author czj
 */
public class ApplePad implements Pad {

    @Override
    public void playGame() {
        System.out.println("使用 苹果 pad 玩游戏");
    }
}
