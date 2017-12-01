package com.xiao.designpatterns.decorator.example.component.impl;

import com.xiao.designpatterns.decorator.example.component.Beverage;

public class CocaCola extends Beverage {
    public Double cost() {
        return Double.valueOf("3.5");
    }

    public String description() {
        return "我是可口可乐";
    }
}
