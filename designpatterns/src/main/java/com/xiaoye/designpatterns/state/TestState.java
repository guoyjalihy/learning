package com.xiao.designpatterns.state;

import com.xiao.designpatterns.state.example.context.Machine;

public class TestState {
    public static void main(String[] args) throws Exception{
        Machine machine = new Machine();
        //1.投入退出
        machine.insertMoney();
        machine.backMoney();
        //2.投入转动出货
        machine.insertMoney();
        machine.turn();
        machine.dispense();

        //3.投入退出转动
        machine.insertMoney();
        machine.backMoney();
        machine.turn();

        //4.投入转动退出
        machine.insertMoney();
        machine.backMoney();
        machine.turn();
        machine.backMoney();
        machine.insertMoney();
        machine.dispense();

        //5.售罄
        machine.insertMoney();
        machine.turn();
        machine.dispense();
        machine.insertMoney();
        machine.turn();
        machine.dispense();
        machine.insertMoney();
        machine.turn();
        machine.dispense();
        machine.insertMoney();
        machine.turn();
        machine.dispense();
        machine.insertMoney();
        machine.turn();
        machine.dispense();
        machine.insertMoney();
        machine.turn();
        machine.dispense();
    }
}
