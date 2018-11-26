package com.xiao.designpatterns.command.example.command.impl;

import com.xiao.designpatterns.command.example.command.Command;
import com.xiao.designpatterns.command.example.receiver.Light;

public class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    public void execute() {
        light.off();
    }

    public void cancel() {
        light.on();
    }
}
