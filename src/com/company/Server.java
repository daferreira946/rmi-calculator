package com.company;

import javax.swing.*;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;

public class Server {

    public static void main(String[] args) {
        try {
            Registry registry = java.rmi.registry.LocateRegistry.createRegistry(8000);
            Rmi calculatorRmi = new Rmi();
            registry.rebind("Calculator", calculatorRmi);
            JOptionPane.showMessageDialog(null, "Server Ready");
        } catch (RemoteException exception) {
            JOptionPane.showMessageDialog(null, "Server failure: " + exception.getMessage());
        }
    }

}
