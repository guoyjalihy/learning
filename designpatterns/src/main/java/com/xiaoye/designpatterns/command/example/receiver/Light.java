package com.xiao.designpatterns.command.example.receiver;

public class Light {
    private String name;
    public Light(String name){
        this.name = name;
    }
    public void on(){
        System.out.println(name + " on");
    }
    public void off(){
        System.out.println(name + " off");
    }
    public void dim(){
        System.out.println(name + " dim");
    }
}
