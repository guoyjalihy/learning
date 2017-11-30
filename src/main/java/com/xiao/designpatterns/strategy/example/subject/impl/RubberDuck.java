package com.xiao.designpatterns.strategy.example.subject.impl;

import com.xiao.designpatterns.strategy.example.strategy.impl.FlyNoWay;
import com.xiao.designpatterns.strategy.example.strategy.impl.Squeak;
import com.xiao.designpatterns.strategy.example.subject.AbstractDuck;

/**
 * 橡皮鸭 会：游泳、吱吱叫 不会：飞
 */
public class RubberDuck extends AbstractDuck{
    public RubberDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Squeak();
    }

    public String name() {
        return "我是橡皮鸭";
    }
}
