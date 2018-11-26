package com.xiao.designpatterns.strategy.example.subject.impl;

import com.xiao.designpatterns.strategy.example.strategy.impl.FlyWithWings;
import com.xiao.designpatterns.strategy.example.strategy.impl.Quack;
import com.xiao.designpatterns.strategy.example.subject.AbstractDuck;

/**
 * 野鸭 会：游泳、飞、呱呱叫
 */
public class MallardDuck extends AbstractDuck {

    public MallardDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    public String name() {
        return "我是野鸭";
    }
}
