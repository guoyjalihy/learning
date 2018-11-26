package com.xiao.designpatterns.proxy.example.local;

import com.xiao.designpatterns.state.example.remote.MachineRemote;

import java.rmi.Naming;

public class MachineMonitor {
    public static void main(String[] args) throws Exception{
        MachineRemote location1 = (MachineRemote) Naming.lookup("location1");
        String l1 = location1.getLocation();
        l1 += location1.getState();
        l1 += location1.getNum();
        System.out.println("location1 result:"+l1);
        MachineRemote location2 = (MachineRemote) Naming.lookup("location2");
        String l2 = location2.getLocation();
        l2 += location2.getState();
        l2 += location2.getNum();
        System.out.println("location2 result:"+l2);
        MachineRemote location3 = (MachineRemote) Naming.lookup("location3");
        String l3 = location3.getLocation();
        l3 += location3.getState();
        l3 += location3.getNum();
        System.out.println("location3 result:"+l3);
    }
}
