package com.xiao.designpatterns.decorator.example.component.impl;

import com.xiao.designpatterns.decorator.example.component.Beverage;

public class Milk extends Beverage {
    public Double cost() {
        return Double.valueOf(5.0);
    }

    public String description() {
        return "我是牛奶";
    }
}
