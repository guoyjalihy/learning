package com.xiao.designpatterns.strategy.example.strategy.impl;

import com.xiao.designpatterns.strategy.example.strategy.QuackBehavior;

/**
 * 策略二实现二：吱吱叫
 */
public class Squeak implements QuackBehavior {
    public String quack() {
        return "吱吱叫";
    }
}
