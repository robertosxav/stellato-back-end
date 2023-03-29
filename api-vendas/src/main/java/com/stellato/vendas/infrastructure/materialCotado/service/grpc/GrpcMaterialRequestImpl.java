package com.stellato.vendas.infrastructure.materialCotado.service.grpc;

import org.springframework.stereotype.Component;

import com.stellato.gprc.fornecedor.FornecedorRequest;
import com.stellato.gprc.fornecedor.FornecedorResponse;
import com.stellato.gprc.fornecedor.FornecedorServiceGrpc.FornecedorServiceBlockingStub;
import com.stellato.gprc.material.MaterialRequest;
import com.stellato.gprc.material.MaterialResponse;
import com.stellato.gprc.material.MaterialServiceGrpc.MaterialServiceBlockingStub;
import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;
import com.stellato.vendas.exceptions.StellatoException;

import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;

@Component
public class GrpcMaterialRequestImpl implements GrpcMaterialRequest{

	@GrpcClient("adm")
	private MaterialServiceBlockingStub materialStub;
	
	@GrpcClient("adm")
	private FornecedorServiceBlockingStub fornecedorStub;

	@Override
	public boolean verificaMaterial(MaterialCotadoEntity materialCotadoEntity) {
		boolean isExisteMaterial = false;
		MaterialRequest materialRequest = MaterialRequest
				.newBuilder().setIdenMaterial(materialCotadoEntity.getIdMaterial().intValue()).build();

		try {
			MaterialResponse materialResponse = materialStub.verificaMaterial(materialRequest);
			isExisteMaterial = materialResponse.getResposta() > 0;
		} catch (StatusRuntimeException e) {
			 throw new StellatoException("Material não encontrado");
		}
		return isExisteMaterial;
	}

	@Override
	public boolean verificaFornecedor(MaterialCotadoEntity materialCotadoEntity) {
		boolean isExisteFornecedor = false;
		FornecedorRequest fornecedorRequest = FornecedorRequest
				.newBuilder().setIdenFornecedor(materialCotadoEntity.getIdFornecedor().intValue()).build();

		try {
			FornecedorResponse fornecedorResponse = fornecedorStub.verificaFornecedor(fornecedorRequest);
			isExisteFornecedor = fornecedorResponse.getResposta() > 0;
		} catch (StatusRuntimeException e) {
			 throw new StellatoException("Fornecedor não encontrado");
		}
		return isExisteFornecedor;
	}
}
