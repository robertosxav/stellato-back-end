package com.stellato.vendas.infrastructure.materialCotado.service.grpc;

import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;

public interface GrpcMaterialRequest {
	public boolean verificaMaterial(MaterialCotadoEntity materialCotadoEntity);
}
