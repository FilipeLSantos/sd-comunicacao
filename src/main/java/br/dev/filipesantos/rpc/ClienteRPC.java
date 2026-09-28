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
        System.out.println("Calculadora [RPC] - SOMA");

        System.out.println("Digite o primeiro número: ");
        double numA = scanner.nextDouble();

        System.out.println("Digite o segundo número: ");
        double numB = scanner.nextDouble();

        SomaRequest request = SomaRequest.newBuilder().setNum1(numA).setNum2(numB).build();

        System.out.println("[RPC] Enviando requisição de soma: " + numA + " + " + numB);
        SomaResponse response = stub.soma(request);

        System.out.println("[RPC] Resultado da soma: " + response.getResultado());

        canal.shutdown();
        scanner.close();
    }
}
