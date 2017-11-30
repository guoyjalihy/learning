package com.xiao.designpatterns.strategy.example.strategy.impl;

import com.xiao.designpatterns.strategy.example.strategy.QuackBehavior;

/**
 * 策略二实现一：呱呱叫
 */
public class Quack implements QuackBehavior {
    public String quack() {
        return "呱呱叫";
    }
}
