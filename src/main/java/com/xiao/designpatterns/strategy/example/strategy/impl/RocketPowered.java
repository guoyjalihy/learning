package com.xiao.designpatterns.strategy.example.strategy.impl;

import com.xiao.designpatterns.strategy.example.strategy.FlyBehavior;

/**
 * 增加一种新的飞行模式：火箭助推。用于模型鸭飞行
 */
public class RocketPowered implements FlyBehavior {
    public String fly() {
        return "用火箭助推飞行";
    }
}
