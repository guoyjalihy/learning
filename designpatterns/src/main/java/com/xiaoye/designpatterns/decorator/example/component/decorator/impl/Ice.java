package com.xiao.designpatterns.decorator.example.component.decorator.impl;

import com.xiao.designpatterns.decorator.example.component.Beverage;
import com.xiao.designpatterns.decorator.example.component.decorator.BeverageDecorator;

public class Ice extends BeverageDecorator {
    private Beverage beverage;
    public Ice(Beverage bvr){
        this.beverage = bvr;
    }
    public Double cost() {
        System.out.println(description());
        return Double.valueOf("0.5") + beverage.cost();
    }

    public String description() {
        return beverage.description()+"加冰.共计：";
    }
}
