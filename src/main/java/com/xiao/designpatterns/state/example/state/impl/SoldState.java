package com.xiao.designpatterns.state.example.state.impl;

import com.xiao.designpatterns.state.example.context.Machine;
import com.xiao.designpatterns.state.example.state.State;

public class SoldState implements State {
    private Machine machine;
    public SoldState(Machine machine){
        this.machine = machine;
    }
    public void insertMoney() {
        System.out.println("正在为您准备出货，请稍等");
    }

    public void backMoney() {
        System.out.println("已经为您备货，无法退钱");
    }

    public void turn() {
        System.out.println("多次转动并不能多给您出货，请勿重复转动");
    }

    public void dispense() {
        System.out.println("出货成功，请尽快取走");
        int num = machine.getNum();
        num--;
        machine.setNum(num);
        if (machine.getNum() > 0){
            machine.setState(machine.getNoMoneyState());
        }else {
            machine.setState(machine.getSoldOutState());
        }
    }
}
