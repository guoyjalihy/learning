package com.xiao.designpatterns.command.example.command.impl;

import com.xiao.designpatterns.command.example.command.Command;
import com.xiao.designpatterns.command.example.receiver.GarageDoor;

public class GarageDoorCloseCommand implements Command {
    private GarageDoor garageDoor;
    public GarageDoorCloseCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }
    public void execute() {
        garageDoor.close();
    }

    public void cancel() {
        garageDoor.open();
    }
}
