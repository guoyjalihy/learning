package com.xiao.designpatterns.state.example.state.impl;

import com.xiao.designpatterns.state.example.context.Machine;
import com.xiao.designpatterns.state.example.state.State;

public class NoMoneyState implements State {
    private Machine machine;
    public NoMoneyState(Machine machine){
        this.machine = machine;
    }
    public void insertMoney() {
        System.out.println("成功投入硬币");
        machine.setState(machine.getHasMoneyState());
    }

    public void backMoney() {
        System.out.println("您还没有投入硬币，请先投硬币");
    }

    public void turn() {
        System.out.println("您还没有投入硬币，转动无效");
    }

    public void dispense() {
        System.out.println("您还没有投入硬币，无法获取物品");
    }
}
