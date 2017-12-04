package com.xiao.designpatterns.state.example.context;

import com.xiao.designpatterns.state.example.remote.MachineRemote;
import com.xiao.designpatterns.state.example.state.State;
import com.xiao.designpatterns.state.example.state.impl.HasMoneyState;
import com.xiao.designpatterns.state.example.state.impl.NoMoneyState;
import com.xiao.designpatterns.state.example.state.impl.SoldOutState;
import com.xiao.designpatterns.state.example.state.impl.SoldState;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Machine extends UnicastRemoteObject implements MachineRemote , Serializable{
    private int num;
    private State noMoneyState;
    private State hasMoneyState;
    private State soldState;
    private State soldOutState;
    private State state;
    private String location;
    public Machine() throws RemoteException{
        num = 5;
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        state = noMoneyState;
    }

    public Machine(String location , int num) throws RemoteException{
        this.num = num;
        this.location = location;
        noMoneyState = new NoMoneyState(this);
        hasMoneyState = new HasMoneyState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        state = noMoneyState;
    }

    public String getState() {
        return state.getClass().getSimpleName();
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void insertMoney(){
        state.insertMoney();
    }
    public void backMoney(){
        state.backMoney();
    }
    public void turn(){
        state.turn();
    }
    public void dispense(){
        state.dispense();
    }

    public State getNoMoneyState() {
        return noMoneyState;
    }

    public State getHasMoneyState() {
        return hasMoneyState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }
}
