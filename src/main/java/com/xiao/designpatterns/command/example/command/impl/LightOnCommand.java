package com.xiao.designpatterns.command.example.command.impl;

import com.xiao.designpatterns.command.example.command.Command;
import com.xiao.designpatterns.command.example.receiver.Light;

public class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute() {
        light.on();
    }

    public void cancel() {
        light.off();
    }
}
