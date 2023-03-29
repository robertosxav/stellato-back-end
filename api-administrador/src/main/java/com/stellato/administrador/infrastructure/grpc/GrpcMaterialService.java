package com.stellato.administrador.infrastructure.grpc;

import org.springframework.beans.factory.annotation.Autowired;

import com.stellato.administrador.domain.material.entity.MaterialEntity;
import com.stellato.administrador.infrastructure.material.service.MaterialService;
import com.stellato.gprc.material.MaterialRequest;
import com.stellato.gprc.material.MaterialResponse;
import com.stellato.gprc.material.MaterialServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcMaterialService extends MaterialServiceGrpc.MaterialServiceImplBase {
	@Autowired
	MaterialService materialService;
	
	@Override
	public void verificaMaterial(MaterialRequest request, StreamObserver<MaterialResponse> responseObserver) {
		int resposta =0;
		MaterialEntity materialEntity= materialService.findById(Long.valueOf(request.getIdenMaterial()));
		if(materialEntity !=null) {
			resposta=1;
		}
		MaterialResponse response = MaterialResponse.newBuilder().setResposta(resposta).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
