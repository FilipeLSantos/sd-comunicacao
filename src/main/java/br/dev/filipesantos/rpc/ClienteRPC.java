package br.dev.filipesantos.rpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.util.Scanner;

public class ClienteRPC {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 50051;

        ManagedChannel canal = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        CalculadoraServiceGrpc.CalculadoraServiceBlockingStub stub = CalculadoraServiceGrpc.newBlockingStub(canal);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Calculadora [RPC]");
        System.out.println("Escolha a operação: 1 - Soma, 2 - Subtração, 3 - Multiplicação, 4 - Divisão");
        int operacao = scanner.nextInt();

        System.out.println("Digite o primeiro número: ");
        double numA = scanner.nextDouble();

        System.out.println("Digite o segundo número: ");
        double numB = scanner.nextDouble();

        NumberRequest request = NumberRequest.newBuilder().setNum1(numA).setNum2(numB).build();

        switch (operacao) {
            case 1:
                System.out.println("[RPC] Enviando requisição de soma: " + numA + " + " + numB);
                ResultResponse response = stub.soma(request);
                System.out.println("[RPC] Resultado da soma: " + response.getResultado());
                break;
            case 2:
                System.out.println("[RPC] Enviando requisição de subtração: " + numA + " - " + numB);
                ResultResponse response2 = stub.subtracao(request);
                System.out.println("[RPC] Resultado da subtração: " + response2.getResultado());
                break;
            case 3:
                System.out.println("[RPC] Enviando requisição de multiplicação: " + numA + " * " + numB);
                ResultResponse response3 = stub.multiplicacao(request);
                System.out.println("[RPC] Resultado da multiplicação: " + response3.getResultado());
                break;
            case 4:
                System.out.println("[RPC] Enviando requisição de divisão: " + numA + " / " + numB);
                ResultResponse response4 = stub.divisao(request);
                System.out.println("[RPC] Resultado da divisão: " + response4.getResultado());
                break;
            default:
                System.out.println("Operação inválida.");
        }

        canal.shutdown();
        scanner.close();
    }
}
