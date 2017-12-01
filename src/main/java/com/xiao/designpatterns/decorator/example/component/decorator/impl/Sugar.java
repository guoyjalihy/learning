package com.xiao.designpatterns.decorator.example.component.decorator.impl;

import com.xiao.designpatterns.decorator.example.component.Beverage;
import com.xiao.designpatterns.decorator.example.component.decorator.BeverageDecorator;

public class Sugar extends BeverageDecorator {

    private Beverage beverage;
    public Sugar(Beverage bvr){
        this.beverage = bvr;
    }
    public Double cost() {
        System.out.println(description());
        return Double.valueOf("1.0") + beverage.cost();
    }

    public String description() {
        return beverage.description()+"加糖.共计：";
    }
}
