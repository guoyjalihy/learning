package com.xiao.designpatterns.decorator.example.component.impl;

import com.xiao.designpatterns.decorator.example.component.Beverage;

public class Coffee extends Beverage {
    public Double cost() {
        return Double.valueOf("15.0");
    }

    public String description() {
        return "我是咖啡";
    }
}
