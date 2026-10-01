package br.dev.filipesantos.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculadoraRMI extends Remote {
    double soma(double num1, double num2) throws RemoteException;
    double subtracao(double num1, double num2) throws RemoteException;
    double multiplicacao(double num1, double num2) throws RemoteException;
    double divisao(double num1, double num2) throws RemoteException;
}
