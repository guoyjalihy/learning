package com.xiao.designpatterns.command.example.command.impl;

import com.xiao.designpatterns.command.example.command.Command;
import com.xiao.designpatterns.command.example.receiver.CeilingFan;
import com.xiao.designpatterns.command.example.receiver.GarageDoor;

public class GarageDoorOpenCommand implements Command {
    private GarageDoor garageDoor;
    public GarageDoorOpenCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }
    public void execute() {
        garageDoor.open();
    }

    public void cancel() {
        garageDoor.close();
    }
}
