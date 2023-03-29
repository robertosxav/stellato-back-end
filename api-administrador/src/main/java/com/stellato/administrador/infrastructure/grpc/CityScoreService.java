package com.stellato.administrador.infrastructure.grpc;

import com.stellato.gprc.cityscore.CityScoreRequest;
import com.stellato.gprc.cityscore.CityScoreResponse;
import com.stellato.gprc.cityscore.CityScoreServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CityScoreService extends CityScoreServiceGrpc.CityScoreServiceImplBase{
	
	 @Override
    public void calculateCityScore(CityScoreRequest request, StreamObserver<CityScoreResponse> responseObserver) {
        // System.out.println("Request received from client:\n" + request);
        Integer cityScore = request.getCityCode() * 10;

        CityScoreResponse response = CityScoreResponse.newBuilder()
                .setCityScore(cityScore)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
