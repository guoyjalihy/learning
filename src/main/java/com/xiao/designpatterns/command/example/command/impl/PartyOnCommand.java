package com.xiao.designpatterns.command.example.command.impl;

import com.xiao.designpatterns.command.example.command.Command;
import com.xiao.designpatterns.command.example.receiver.CeilingFan;
import com.xiao.designpatterns.command.example.receiver.Light;
import com.xiao.designpatterns.command.example.receiver.Stereo;

public class PartyOnCommand implements Command {
    private Light light;
    private CeilingFan ceilingFan;
    private Stereo stereo;
    public PartyOnCommand(){
        light = new Light("客厅");
        ceilingFan = new CeilingFan();
        stereo = new Stereo();
    }
    public void execute() {
        light.on();
        light.dim();
        ceilingFan.on();
        ceilingFan.lowSpeed();
        stereo.on();
        stereo.setCd();
        stereo.setVolume();
    }

    public void cancel() {
        light.off();
        ceilingFan.off();
        stereo.off();
    }
}
