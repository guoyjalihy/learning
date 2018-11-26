package com.xiao.designpatterns.proxy.example.registry;

import com.xiao.designpatterns.state.example.context.Machine;
import com.xiao.designpatterns.state.example.remote.MachineRemote;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class MachineRegistry {
    public static void main(String[] args) throws Exception{
        MachineRemote machine1 = new Machine("location1",100);
        MachineRemote machine2 = new Machine("location2",200);
        MachineRemote machine3 = new Machine("location3",300);

        try {
            Naming.rebind("location1",machine1);
            Naming.rebind("location2",machine2);
            Naming.rebind("location3",machine3);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        System.out.println("注册成功");
    }
}
