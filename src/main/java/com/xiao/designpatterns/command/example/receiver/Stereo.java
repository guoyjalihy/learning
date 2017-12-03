package com.xiao.designpatterns.command.example.receiver;

public class Stereo {
    public void on(){
        System.out.println("Stereo is on");
    }
    public void off(){
        System.out.println("Stereo is off");
    }
    public void setCd(){
        System.out.println("Stereo is already set cd");
    }
    public void setVolume(){
        System.out.println("Stereo is already set Volume");
    }
}
