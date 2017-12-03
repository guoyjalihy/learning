package com.xiao.designpatterns.command.example.command.impl;

import com.xiao.designpatterns.command.example.command.Command;
import com.xiao.designpatterns.command.example.receiver.Stereo;

public class StereoOffCommand implements Command {
    private Stereo stereo;
    public StereoOffCommand(Stereo stereo){
        this.stereo = stereo;
    }
    public void execute() {

        stereo.off();
    }

    public void cancel() {
        stereo.on();
        stereo.setCd();
        stereo.setVolume();
    }
}
