package br.dev.filipesantos.rpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

import java.io.IOException;

public class ServidorRPC {
    private static final int PORT = 50051;

    public static void main(String[] args)throws IOException, InterruptedException{
        Server server = ServerBuilder.forPort(PORT).addService(new CalculadoraServiceImpl()).build().start();

        System.out.println("[RPC] Servidor inciando e escutando na porta " + PORT);

        server.awaitTermination();
    }
}
