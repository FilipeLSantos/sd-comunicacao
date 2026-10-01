package br.dev.filipesantos.Socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket ("localhost", 5000);


        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));

        PrintWriter saida = new PrintWriter(
            socket.getOutputStream(), true
        );

        Scanner scanner = new Scanner(System.in);
        
        while (true) 
        {

            System.out.print(
                "Digite a operação (+, -, *, /) ou SAIR: "
            );

            String operacao = scanner.nextLine();

            if (operacao.equalsIgnoreCase("SAIR")) {
                saida.println("SAIR");
                break;
            }

            System.out.print("Digite o primeiro número: ");
            String numero1 = scanner.nextLine();

            System.out.print("Digite o segundo número: ");
            String numero2 = scanner.nextLine();

            String mensagem =
                operacao + ";" + numero1 + ";" + numero2;

            saida.println(mensagem);

            String resposta = entrada.readLine();

            System.out.println(
                "Servidor respondeu: " + resposta
            );

            System.out.println();
        }

        scanner.close();
        socket.close();

        System.out.println("Conexão encerrada.");
    }
}