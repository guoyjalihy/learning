package com.xiao.designpatterns.command.example.receiver;

public class CeilingFan {
    public void on(){
        System.out.println("CeilingFan is on");
    }
    public void off(){
        System.out.println("CeilingFan is off");
    }
    public void highSpeed(){
        System.out.println("CeilingFan is highSpeed");
    }
    public void lowSpeed(){
        System.out.println("CeilingFan is lowSpeed");
    }
}
