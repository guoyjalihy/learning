package com.xiao.designpatterns.factory;

import com.xiao.designpatterns.factory.example.factorymethod.PizzaStore;
import com.xiao.designpatterns.factory.example.factorymethod.impl.ChicagoStylePizzaStore;
import com.xiao.designpatterns.factory.example.factorymethod.impl.NYStylePizzaStore;

public class TestFactory {
    public static void main(String[] args) throws Exception {
        PizzaStore pizzaStore = new NYStylePizzaStore();
        pizzaStore.orderPizza("cheese");
        pizzaStore = new ChicagoStylePizzaStore();
        pizzaStore.orderPizza("clam");
    }
}