package com.stellato.vendas.infrastructure.materialCotado.service.grpc;

import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;

public interface GrpcMaterialRequest {
	public MaterialCotadoEntity verificaMaterial(MaterialCotadoEntity materialCotadoEntity);
	public MaterialCotadoEntity verificaFornecedor(MaterialCotadoEntity materialCotadoEntity);
}
