package br.dev.filipesantos.rmi;

import java.rmi.server.UnicastRemoteObject;

public class CalculadoraRMIImpl extends UnicastRemoteObject implements ICalculadoraRMI {

    protected CalculadoraRMIImpl() throws java.rmi.RemoteException {
        super();
    }

    @Override
    public double soma(double num1, double num2) throws java.rmi.RemoteException {
        System.out.println("[RMI] Processando soma: " + num1 + " + " + num2);
        return num1 + num2;
    }

    @Override
    public double subtracao(double num1, double num2) throws java.rmi.RemoteException {
        System.out.println("[RMI] Processando subtração: " + num1 + " - " + num2);
        return num1 - num2;
    }

    @Override
    public double multiplicacao(double num1, double num2) throws java.rmi.RemoteException {
        System.out.println("[RMI] Processando multiplicação: " + num1 + " * " + num2);
        return num1 * num2;
    }

    @Override
    public double divisao(double num1, double num2) throws java.rmi.RemoteException {
        System.out.println("[RMI] Processando divisão: " + num1 + " / " + num2);
        return num1 / num2;
    }
}
