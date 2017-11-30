package com.xiao.designpatterns.strategy.example.subject.impl;

import com.xiao.designpatterns.strategy.example.strategy.impl.FlyNoWay;
import com.xiao.designpatterns.strategy.example.strategy.impl.MuteQuack;
import com.xiao.designpatterns.strategy.example.subject.AbstractDuck;

/**
 * 新增一种模型鸭 会：游泳 不会：飞、叫。通过动态设置火箭动力飞行可以飞。
 */
public class ModelDuck extends AbstractDuck {
    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new MuteQuack();
    }

    public String name() {
        return "我叫模型鸭";
    }
}
