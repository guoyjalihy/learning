package com.xiao.designpatterns.decorator;

import com.xiao.designpatterns.decorator.example.component.Beverage;
import com.xiao.designpatterns.decorator.example.component.decorator.impl.Ice;
import com.xiao.designpatterns.decorator.example.component.decorator.impl.Mel;
import com.xiao.designpatterns.decorator.example.component.decorator.impl.Sugar;
import com.xiao.designpatterns.decorator.example.component.impl.CocaCola;
import com.xiao.designpatterns.decorator.example.component.impl.Coffee;

public class TestDecorator {
    public static void main(String[] args) throws Exception{
        //可口可乐加冰 4.5
        Beverage beverage = new CocaCola();
        beverage = new Ice(beverage);
        System.out.println(beverage.cost());
        //咖啡加糖 16.0
        beverage = new Coffee();
        beverage = new Sugar(beverage);
        System.out.println(beverage.cost());
        //新增一种蜂蜜，咖啡加蜂蜜 20.0
        beverage = new Coffee();
        beverage = new Mel(beverage);
        System.out.println(beverage.cost());
    }
}
