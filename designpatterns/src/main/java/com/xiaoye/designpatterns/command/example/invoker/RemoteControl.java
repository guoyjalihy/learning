package com.xiao.designpatterns.command.example.invoker;

import com.xiao.designpatterns.command.example.command.Command;
import com.xiao.designpatterns.command.example.command.impl.*;
import com.xiao.designpatterns.command.example.receiver.CeilingFan;
import com.xiao.designpatterns.command.example.receiver.GarageDoor;
import com.xiao.designpatterns.command.example.receiver.Light;
import com.xiao.designpatterns.command.example.receiver.Stereo;

import java.util.ArrayList;
import java.util.List;

public class RemoteControl {
    private List<Command> leftCommand;
    private List<Command> rightCommand;
    private List<Command> cancelCommand;
    public RemoteControl(){
        leftCommand = new ArrayList<Command>();
        rightCommand = new ArrayList<Command>();
        cancelCommand = new ArrayList<Command>();

        Light light = new Light("客厅灯");
        CeilingFan ceilingFan = new CeilingFan();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        CeilingFanOnCommand ceilingFanOnCommand = new CeilingFanOnCommand(ceilingFan);
        GarageDoorOpenCommand garageDoorOpenCommand = new GarageDoorOpenCommand(garageDoor);
        StereoOnCommand stereoOnCommand = new StereoOnCommand(stereo);
        PartyOnCommand partyCommand = new PartyOnCommand();
        leftCommand.add(lightOnCommand);
        leftCommand.add(ceilingFanOnCommand);
        leftCommand.add(garageDoorOpenCommand);
        leftCommand.add(stereoOnCommand);
        leftCommand.add(partyCommand);

        LightOffCommand lightOffCommand = new LightOffCommand(light);
        CeilingFanOffCommand ceilingFanOffCommand = new CeilingFanOffCommand(ceilingFan);
        GarageDoorCloseCommand garageDoorCloseCommand  = new GarageDoorCloseCommand(garageDoor);
        StereoOffCommand stereoOffCommand = new StereoOffCommand(stereo);
        PartyOffCommand partyOffCommand = new PartyOffCommand();
        rightCommand.add(lightOffCommand);
        rightCommand.add(ceilingFanOffCommand);
        rightCommand.add(garageDoorCloseCommand);
        rightCommand.add(stereoOffCommand);
        rightCommand.add(partyOffCommand);
    }

    private void addCancelCommand(Command command){
        cancelCommand.add(command);
    }
    public void pressLeftOneButton(){
        System.out.println("左一按钮按下");
        Command command = leftCommand.get(0);
        command.execute();
        addCancelCommand(command);
        System.out.println("左一按钮按下 end");
    }

    public void pressLeftTwoButton(){
        System.out.println("左二按钮按下");
        Command command = leftCommand.get(1);
        command.execute();
        addCancelCommand(command);
        System.out.println("左二按钮按下 end");
    }

    public void pressLeftThreeButton(){
        System.out.println("左三按钮按下");
        Command command = leftCommand.get(2);
        command.execute();
        addCancelCommand(command);
        System.out.println("左三按钮按下 end");
    }

    public void pressLeftFourButton(){
        System.out.println("左四按钮按下");
        Command command = leftCommand.get(3);
        command.execute();
        addCancelCommand(command);
        System.out.println("左四按钮按下 end");
    }

    public void pressLeftFiveButton(){
        System.out.println("左五按钮按下");
        Command command = leftCommand.get(4);
        command.execute();
        addCancelCommand(command);
        System.out.println("左五按钮按下 end");
    }
    public void pressRightOneButton(){
        System.out.println("右一按钮按下");
        Command command = rightCommand.get(0);
        command.execute();
        addCancelCommand(command);
        System.out.println("右一按钮按下 end");
    }

    public void pressRightTwoButton(){
        System.out.println("右二按钮按下");
        Command command = rightCommand.get(1);
        command.execute();
        addCancelCommand(command);
        System.out.println("右二按钮按下 end");
    }

    public void pressRightThreeButton(){
        System.out.println("右三按钮按下");
        Command command = rightCommand.get(2);
        command.execute();
        addCancelCommand(command);
        System.out.println("右三按钮按下 end");
    }

    public void pressRightFourButton(){
        System.out.println("右四按钮按下");
        Command command = rightCommand.get(3);
        command.execute();
        addCancelCommand(command);
        System.out.println("右四按钮按下 end");
    }

    public void pressRightFiveButton(){
        System.out.println("右五按钮按下 begin");
        Command command = rightCommand.get(4);
        command.execute();
        addCancelCommand(command);
        System.out.println("右五按钮按下 end");
    }

    public void pressCancelButton(){
        if (cancelCommand.size() <= 0){
            System.out.println("已经没有记录了");
            return;
        }
        Command command = cancelCommand.get(cancelCommand.size()-1);
        System.out.println(command.getClass().getName() + "执行了撤销动作。");
        command.cancel();

        cancelCommand.remove(cancelCommand.size()-1);
    }

    public List<Command> getLeftCommand() {
        return leftCommand;
    }

    public void setLeftCommand(List<Command> leftCommand) {
        this.leftCommand = leftCommand;
    }

    public List<Command> getRightCommand() {
        return rightCommand;
    }

    public void setRightCommand(List<Command> rightCommand) {
        this.rightCommand = rightCommand;
    }
}
