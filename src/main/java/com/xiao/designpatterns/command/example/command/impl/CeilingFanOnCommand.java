package com.xiao.designpatterns.command.example.command.impl;

import com.xiao.designpatterns.command.example.command.Command;
import com.xiao.designpatterns.command.example.receiver.CeilingFan;

public class CeilingFanOnCommand implements Command {
    private CeilingFan ceilingFan;
    public CeilingFanOnCommand(CeilingFan ceilingFan){
        this.ceilingFan = ceilingFan;
    }
    public void execute() {
        ceilingFan.on();
    }

    public void cancel() {
        ceilingFan.off();
    }
}
