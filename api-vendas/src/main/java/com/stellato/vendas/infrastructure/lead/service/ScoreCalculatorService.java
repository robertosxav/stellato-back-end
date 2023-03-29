package com.stellato.vendas.infrastructure.lead.service;


import org.springframework.stereotype.Service;

import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.rpc.Status;
import com.stellato.gprc.cityscore.CityScoreExceptionResponse;
import com.stellato.gprc.cityscore.CityScoreRequest;
import com.stellato.gprc.cityscore.CityScoreResponse;
import com.stellato.gprc.cityscore.CityScoreServiceGrpc.CityScoreServiceBlockingStub;

import io.grpc.StatusRuntimeException;
import io.grpc.protobuf.StatusProto;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Service
public class ScoreCalculatorService {
	
	@GrpcClient("adm")
    private CityScoreServiceBlockingStub cityScoreStub;
	
	 public Integer getCityScore(Integer cityCode) {
		
		 
	      CityScoreRequest cityScoreRequest = CityScoreRequest.newBuilder()
	                                                            .setCityCode(cityCode)
	                                                            .build();
	        try {
	            CityScoreResponse cityScoreResponse = cityScoreStub.calculateCityScore(cityScoreRequest);
	            return cityScoreResponse.getCityScore();
	        } catch (StatusRuntimeException e){
	            Status status = StatusProto.fromThrowable(e);
	            for (Any any : status.getDetailsList()) {
	                if (!any.is(CityScoreExceptionResponse.class)) {
	                    continue;
	                }
	                try {
	                    CityScoreExceptionResponse exceptionResponse = any.unpack(CityScoreExceptionResponse.class);
	                    System.out.println("timestamp: " + exceptionResponse.getTimestamp() +
	                            ", errorCode : " + exceptionResponse.getErrorCode());
	                } catch (InvalidProtocolBufferException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            // System.out.println(status.getCode() + " : " + status.getDescription());
	        }

	        // return a default value
	        return Integer.valueOf(1);
	    }
}
