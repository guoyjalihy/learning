package com.xiao.designpatterns.command;

import com.xiao.designpatterns.command.example.invoker.RemoteControl;

public class TestCommand {
    public static void main(String[] args) throws Exception{
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.pressLeftOneButton();
        remoteControl.pressLeftTwoButton();
        remoteControl.pressLeftThreeButton();
        remoteControl.pressLeftFourButton();
        remoteControl.pressLeftFiveButton();

        remoteControl.pressRightOneButton();
        remoteControl.pressRightTwoButton();
        remoteControl.pressRightThreeButton();
        remoteControl.pressRightFourButton();
        remoteControl.pressRightFiveButton();


        remoteControl.pressCancelButton();
    }
}
