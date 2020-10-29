package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

    double div(double numberOne, double numberTwo) throws RemoteException;
    double multi(double numberOne, double numberTwo) throws RemoteException;
    double plus(double numberOne, double numberTwo) throws RemoteException;
    double minus(double numberOne, double numberTwo) throws RemoteException;

}
