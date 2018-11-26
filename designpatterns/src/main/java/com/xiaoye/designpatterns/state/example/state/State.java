package com.xiao.designpatterns.state.example.state;

import java.io.Serializable;

public interface State extends Serializable{
    void insertMoney();
    void backMoney();
    void turn();
    void dispense();
}
