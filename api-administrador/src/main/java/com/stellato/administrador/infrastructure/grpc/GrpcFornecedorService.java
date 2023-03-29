package com.stellato.administrador.infrastructure.grpc;

import org.springframework.beans.factory.annotation.Autowired;

import com.stellato.administrador.domain.fornecedor.entity.FornecedorEntity;
import com.stellato.administrador.infrastructure.fornecedor.service.FornecedorService;
import com.stellato.gprc.fornecedor.FornecedorRequest;
import com.stellato.gprc.fornecedor.FornecedorResponse;
import com.stellato.gprc.fornecedor.FornecedorServiceGrpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GrpcFornecedorService extends FornecedorServiceGrpc.FornecedorServiceImplBase {
	@Autowired
	FornecedorService fornecedorService;
	
	@Override
	public void verificaFornecedor(FornecedorRequest request, StreamObserver<FornecedorResponse> responseObserver) {
		int resposta =0;
		FornecedorEntity fornecedorEntity= fornecedorService.findById(Long.valueOf(request.getIdenFornecedor()));
		if(fornecedorEntity !=null) {
			resposta=1;
		}
		FornecedorResponse response = FornecedorResponse.newBuilder().setResposta(resposta).build();
		responseObserver.onNext(response);
		responseObserver.onCompleted();
	}
}
