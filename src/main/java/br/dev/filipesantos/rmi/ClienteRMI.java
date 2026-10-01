package br.dev.filipesantos.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class ClienteRMI {
    public static void main(String[] args) {
        try {
            String host = "localhost";
            int port = 1099;
            Registry registry = LocateRegistry.getRegistry(host, port);
            ICalculadoraRMI calculadora = (ICalculadoraRMI) registry.lookup("CalculadoraRMI");
            Scanner scanner = new Scanner(System.in);

            System.out.println("[RMI] Calculadora");
            System.out.println("Escolha a operação: 1 - Soma, 2 - Subtração, 3 - Multiplicação, 4 - Divisão");
            int operacao = scanner.nextInt();

            System.out.println("Digite o primeiro número:");
            double num1 = scanner.nextDouble();

            System.out.println("Digite o segundo número:");
            double num2 = scanner.nextDouble();

            switch (operacao){
                case 1:
                    System.out.println("Resultado: " + calculadora.soma(num1, num2));
                    break;
                case 2:
                    System.out.println("Resultado: " + calculadora.subtracao(num1, num2));
                    break;
                case 3:
                    System.out.println("Resultado: " + calculadora.multiplicacao(num1, num2));
                    break;
                case 4:
                    System.out.println("Resultado: " + calculadora.divisao(num1, num2));
                    break;
                default:
                    System.out.println("Operação inválida.");
            }

        } catch (Exception e) {
            System.err.println("[RMI] Erro ao conectar ao servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
