package br.dev.filipesantos.rpc;

import io.grpc.stub.StreamObserver;

public class CalculadoraServiceImpl extends CalculadoraServiceGrpc.CalculadoraServiceImplBase {

    @Override
    public void soma(NumberRequest request, StreamObserver<ResultResponse> responseObserver){
        double numA = request.getNum1();
        double numB = request.getNum2();

        System.out.println("[RPC] Processando soma: " + numA + " + " + numB);
        double result = numA + numB;

        ResultResponse response = ResultResponse.newBuilder().setResultado(result).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void subtracao(NumberRequest request, StreamObserver<ResultResponse> responseObserver) {
        double numA = request.getNum1();
        double numB = request.getNum2();

        System.out.println("[RPC] Processando subtração: " + numA + " - " + numB);

        double result = numA - numB;

        ResultResponse response = ResultResponse.newBuilder().setResultado(result).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void multiplicacao(NumberRequest request, StreamObserver<ResultResponse> responseObserver) {
        double numA = request.getNum1();
        double numB = request.getNum2();

        System.out.println("[RPC] Processando multiplicação: " + numA + " * " + numB);

        double result = numA * numB;

        ResultResponse response = ResultResponse.newBuilder().setResultado(result).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void divisao(NumberRequest request, StreamObserver<ResultResponse> responseObserver) {
        double numA = request.getNum1();
        double numB = request.getNum2();

        System.out.println("[RPC] Processando divisão: " + numA + " / " + numB);

        double result = numA / numB;

        ResultResponse response = ResultResponse.newBuilder().setResultado(result).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
