package com.company;

import javax.swing.*;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            Calculator calculator = (Calculator)Naming.lookup("rmi://localhost:8000/Calculator");
            boolean active = true;
            while (active) {
                String menu = JOptionPane.showInputDialog(
                        """
                        Calculadora:
                        Soma => +
                        Subtração => -
                        Multiplicação => *
                        Divisão => /
                        
                        Para fechar => sair
                        """
                );

                switch (menu) {
                    case "+":{
                        Double[] numbers = read();
                        double result = calculator.plus(numbers[0], numbers[1]);
                        print(result);
                        break;
                    }

                    case "-":{
                        Double[] numbers = read();
                        double result = calculator.minus(numbers[0], numbers[1]);
                        print(result);
                        break;
                    }

                    case "*":{
                        Double[] numbers = read();
                        double result = calculator.multi(numbers[0], numbers[1]);
                        print(result);
                        break;
                    }

                    case "/":{
                        Double[] numbers = read();
                        try {
                        double result = calculator.div(numbers[0], numbers[1]);
                        print(result);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, "Divisão por 0 não disponível");
                        }
                        break;
                    }

                    case "sair":{
                        active = false;
                        break;
                    }

                    default: {
                        JOptionPane.showMessageDialog(null, "Operador inválido");
                    }
                }
            }

        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null, "Server refused:" + exception.getMessage());
        }
    }

    private static void print(double result) {
        JOptionPane.showMessageDialog(null, "O resultado é:" + result);
    }

    private static Double[] read() {
        Double[] numbers = new Double[2];
        numbers[0] = Double.parseDouble(JOptionPane.showInputDialog("Insira o primeiro número:"));
        numbers[1] = Double.parseDouble(JOptionPane.showInputDialog("Insira o segundo número:"));
        return numbers;
    }
}
