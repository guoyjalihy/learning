package com.xiao.designpatterns.strategy.example.strategy.impl;

import com.xiao.designpatterns.strategy.example.strategy.FlyBehavior;

/**
 * 策略一实现二：不会飞
 */
public class FlyNoWay implements FlyBehavior {
    public String fly() {
        return "不会飞";
    }
}
