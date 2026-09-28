package br.dev.filipesantos.rpc;

import io.grpc.stub.StreamObserver;

public class CalculadoraServiceImpl extends CalculadoraServiceGrpc.CalculadoraServiceImplBase {

    @Override
    public void soma(SomaRequest request, StreamObserver<SomaResponse> responseObserver){
        double numA = request.getNum1();
        double numB = request.getNum2();

        System.out.println("[RPC] Processando soma: " + numA + " + " + numB);
        double result = numA + numB;

        SomaResponse response = SomaResponse.newBuilder().setResultado(result).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
