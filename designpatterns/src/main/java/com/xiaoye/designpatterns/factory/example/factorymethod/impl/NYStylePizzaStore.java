package com.xiao.designpatterns.factory.example.factorymethod.impl;

import com.xiao.designpatterns.factory.example.factorymethod.PizzaStore;
import com.xiao.designpatterns.factory.example.product.Pizza;
import com.xiao.designpatterns.factory.example.product.impl.NYStyleCheesePizza;
import com.xiao.designpatterns.factory.example.product.impl.NYStyleClamPizza;

public class NYStylePizzaStore extends PizzaStore {

    public Pizza createPizza(String type) {
        System.out.println("NY "+ type);
        if ("cheese".equals(type)){
            return new NYStyleCheesePizza();
        }else if ("clam".equals(type)){
            return new NYStyleClamPizza();
        }else{
            return null;
        }
    }
}
