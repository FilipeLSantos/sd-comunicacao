package br.dev.filipesantos.Socket;

import java.io.*;
import java.net.*;

public class Servidor {

    public static void main(String[] args) throws IOException {

        int porta = args.length > 0
        ? Integer.parseInt(args[0])
        : 5000;

        ServerSocket servidor = new ServerSocket(porta);

        System.out.println("Servidor aguardando conexão...");

        Socket cliente = servidor.accept();

        System.out.println("Cliente conectado!");

        BufferedReader entrada = new BufferedReader(
            new InputStreamReader(cliente.getInputStream())
        );

        PrintWriter saida = new PrintWriter(
            cliente.getOutputStream(), true
        );

       while (true) {

            String mensagem = entrada.readLine();

            if (mensagem == null ||
                mensagem.equalsIgnoreCase("SAIR")) {

                break;
            }

            System.out.println(
                "Cliente enviou: " + mensagem
            );

            String[] partes = mensagem.split(";");

            if (partes.length != 3) {
                saida.println("ERRO: mensagem inválida.");
                continue;
            }

            String operacao = partes[0];

            double numero1;
            double numero2;

            try {

                numero1 = Double.parseDouble(partes[1]);
                numero2 = Double.parseDouble(partes[2]);

            } catch (NumberFormatException e) {

                saida.println(
                    "ERRO: os valores precisam ser números."
                );

                continue;
            }

            double resultado;

            switch (operacao) {

                case "+":
                    resultado = numero1 + numero2;
                    break;

                case "-":
                    resultado = numero1 - numero2;
                    break;

                case "*":
                    resultado = numero1 * numero2;
                    break;

                case "/":

                    if (numero2 == 0) {
                        saida.println(
                            "ERRO: divisão por zero."
                        );
                        continue;
                    }

                    resultado = numero1 / numero2;
                    break;

                default:

                    saida.println(
                        "ERRO: operação inválida."
                    );

                    continue;
            }

            saida.println(resultado);
        }

        cliente.close();
        servidor.close();

        System.out.println("Conexão encerrada.");
    }
}