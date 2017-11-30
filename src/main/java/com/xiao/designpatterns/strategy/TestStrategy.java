package com.xiao.designpatterns.strategy;

import com.xiao.designpatterns.strategy.example.strategy.impl.RocketPowered;
import com.xiao.designpatterns.strategy.example.subject.AbstractDuck;
import com.xiao.designpatterns.strategy.example.subject.impl.*;

public class TestStrategy {
    public static void main(String[] args) throws Exception{
        AbstractDuck duck;
        //测试一：野鸭 会：游泳、飞、呱呱叫
        duck = new MallardDuck();
        duck.display();
        System.out.println("========================");
        //测试二：红头野鸭 会：游泳、飞、呱呱叫
        duck = new ReaheadDuck();
        duck.display();
        System.out.println("========================");
        //测试三：橡皮鸭 会：游泳、吱吱叫 不会：飞
        duck = new RubberDuck();
        duck.display();
        System.out.println("========================");
        //测试四：诱饵鸭 会：游泳
        duck = new DecoyDuck();
        duck.display();
        System.out.println("========================");
        //测试五：新增一种模型鸭 会游泳 不会：飞、叫
        duck = new ModelDuck();
        duck.display();
        System.out.println("========================");
        duck.setFlyBehavior(new RocketPowered());
        duck.display();
    }
}
