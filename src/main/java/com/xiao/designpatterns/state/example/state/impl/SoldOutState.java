package com.xiao.designpatterns.state.example.state.impl;

import com.xiao.designpatterns.state.example.context.Machine;
import com.xiao.designpatterns.state.example.state.State;

public class SoldOutState implements State {
    private Machine machine;
    public SoldOutState(Machine machine){
        this.machine = machine;
    }
    public void insertMoney() {
        System.out.println("货物售罄");
    }

    public void backMoney() {
        System.out.println("货物售罄");
    }

    public void turn() {
        System.out.println("货物售罄");
    }

    public void dispense() {
        System.out.println("货物售罄");
    }
}
