package com.xiao.designpatterns.command.example.command.impl;

import com.xiao.designpatterns.command.example.command.Command;
import com.xiao.designpatterns.command.example.receiver.CeilingFan;

public class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;
    public CeilingFanOffCommand(CeilingFan ceilingFan){
        this.ceilingFan = ceilingFan;
    }
    public void execute() {
        ceilingFan.off();
    }

    public void cancel() {
        ceilingFan.on();
    }
}
