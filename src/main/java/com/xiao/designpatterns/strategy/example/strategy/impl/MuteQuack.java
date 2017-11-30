package com.xiao.designpatterns.strategy.example.strategy.impl;

import com.xiao.designpatterns.strategy.example.strategy.QuackBehavior;

/**
 * 策略二实现三：不会叫
 */
public class MuteQuack implements QuackBehavior {
    public String quack() {
        return "不会叫";
    }
}
