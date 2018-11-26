package com.xiao.designpatterns.command.example.command.impl;

import com.xiao.designpatterns.command.example.command.Command;
import com.xiao.designpatterns.command.example.receiver.Stereo;

public class StereoOnCommand implements Command {
    private Stereo stereo;
    public StereoOnCommand(Stereo stereo){
        this.stereo = stereo;
    }
    public void execute() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume();
    }

    public void cancel() {
        stereo.off();
    }
}
