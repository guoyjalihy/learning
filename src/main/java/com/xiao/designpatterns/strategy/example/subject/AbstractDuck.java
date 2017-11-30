package com.xiao.designpatterns.strategy.example.subject;

import com.xiao.designpatterns.strategy.example.strategy.FlyBehavior;
import com.xiao.designpatterns.strategy.example.strategy.QuackBehavior;

public abstract class AbstractDuck {
    protected QuackBehavior quackBehavior;
    protected FlyBehavior flyBehavior;

    public String swim(){
        return "会游泳";
    }

    public void display(){
        System.out.println(name());
        System.out.println("我" + swim());
        System.out.println("我" + fly());
        System.out.println("我" + quack());
    }

    public abstract String name();

    public String fly(){
        return flyBehavior.fly();
    }

    public String quack(){
        return quackBehavior.quack();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}
