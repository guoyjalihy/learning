package com.xiao.designpatterns.strategy.example.strategy.impl;

import com.xiao.designpatterns.strategy.example.strategy.FlyBehavior;

/**
 * 策略一实现一：翅膀飞
 */
public class FlyWithWings implements FlyBehavior {
    public String fly() {
        return "使用翅膀飞";
    }
}
