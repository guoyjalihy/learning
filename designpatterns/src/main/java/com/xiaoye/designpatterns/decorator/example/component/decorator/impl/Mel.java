package com.xiao.designpatterns.decorator.example.component.decorator.impl;

import com.xiao.designpatterns.decorator.example.component.Beverage;

public class Mel extends Beverage{
    private Beverage beverage;
    public Mel(Beverage bvr){
        this.beverage = bvr;
    }
    public Double cost() {
        System.out.println(description());
        return Double.valueOf("5.0") + beverage.cost();
    }

    public String description() {
        return beverage.description()+"加蜂蜜.共计：";
    }
}
