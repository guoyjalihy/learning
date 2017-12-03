package com.xiao.designpatterns.state.example.state.impl;

import com.xiao.designpatterns.state.example.context.Machine;
import com.xiao.designpatterns.state.example.state.State;

public class HasMoneyState implements State {
    private Machine machine;
    public HasMoneyState(Machine machine){
        this.machine = machine;
    }
    public void insertMoney() {
        System.out.println("您已经投入硬币，请勿重复");
    }

    public void backMoney() {
        System.out.println("成功退出硬币，谢谢使用");
        machine.setState(machine.getNoMoneyState());
    }

    public void turn() {
        System.out.println("转动成功，等待出货");
        machine.setState(machine.getSoldState());
    }

    public void dispense() {
        System.out.println("请先转动手柄");
    }
}
