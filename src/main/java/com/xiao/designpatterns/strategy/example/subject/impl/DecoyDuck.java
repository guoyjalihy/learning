package com.xiao.designpatterns.strategy.example.subject.impl;

import com.xiao.designpatterns.strategy.example.strategy.impl.FlyNoWay;
import com.xiao.designpatterns.strategy.example.strategy.impl.MuteQuack;
import com.xiao.designpatterns.strategy.example.subject.AbstractDuck;

/**
 * 诱饵鸭 会：游泳
 */
public class DecoyDuck extends AbstractDuck {

    public DecoyDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    public String name() {
        return "我是诱饵鸭";
    }
}
