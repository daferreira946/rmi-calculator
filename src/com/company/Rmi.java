package com.company;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Rmi extends UnicastRemoteObject implements Calculator {

    public Rmi() throws RemoteException {
        double numberOne, numberTwo;
    }


    @Override
    public double div(double numberOne, double numberTwo) throws RemoteException {
        if (numberTwo == Double.parseDouble("0")) {
            throw new RemoteException();
        }

        return numberOne/numberTwo;
    }

    @Override
    public double multi(double numberOne, double numberTwo) throws RemoteException {
        return numberOne*numberTwo;
    }

    @Override
    public double plus(double numberOne, double numberTwo) throws RemoteException {
        return numberOne+numberTwo;
    }

    @Override
    public double minus(double numberOne, double numberTwo) throws RemoteException {
        return numberOne-numberTwo;
    }
}
