package br.dev.filipesantos.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            ICalculadoraRMI calculadora = new CalculadoraRMIImpl();

            registry.rebind("CalculadoraRMI", calculadora);

            System.out.println("[RMI] Servidor iniciado e escutando na porta 1099");
        } catch (Exception e) {
            System.err.println("[RMI] Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
