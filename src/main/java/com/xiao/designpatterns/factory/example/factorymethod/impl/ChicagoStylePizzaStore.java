package com.xiao.designpatterns.factory.example.factorymethod.impl;

import com.xiao.designpatterns.factory.example.factorymethod.PizzaStore;
import com.xiao.designpatterns.factory.example.product.Pizza;
import com.xiao.designpatterns.factory.example.product.impl.ChicagoStyleCheesePizza;
import com.xiao.designpatterns.factory.example.product.impl.ChicagoStyleClamPizza;

public class ChicagoStylePizzaStore extends PizzaStore {

    public Pizza createPizza(String type) {
        System.out.println("Chicago "+ type);
        if ("cheese".equals(type)){
            return new ChicagoStyleCheesePizza();
        }else if ("clam".equals(type)){
            return new ChicagoStyleClamPizza();
        }else{
            return null;
        }
    }
}
