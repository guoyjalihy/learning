package com.xiao.designpatterns.state.example.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MachineRemote extends Remote {
    int getNum() throws RemoteException;
    String getLocation() throws RemoteException;
    String getState() throws RemoteException;
}
