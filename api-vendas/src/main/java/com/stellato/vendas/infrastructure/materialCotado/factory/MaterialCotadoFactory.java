package com.stellato.vendas.infrastructure.materialCotado.factory;

import org.springframework.stereotype.Component;

import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;
import com.stellato.vendas.infrastructure.materialCotado.MaterialCotadoModel;


@Component
public class MaterialCotadoFactory {
	
	public MaterialCotadoModel create (MaterialCotadoEntity materialCotadoEntity) {		
		MaterialCotadoModel materialCotadoModel = new MaterialCotadoModel(materialCotadoEntity.getId(), materialCotadoEntity.getObservacao(),materialCotadoEntity.getValor(),materialCotadoEntity.getIdFornecedor(),
				materialCotadoEntity.getIdMaterial(),materialCotadoEntity.getStatus().getNumero(),materialCotadoEntity.getCriadoEm(), materialCotadoEntity.getCriadoPor(), materialCotadoEntity.getAlteradoEm(), 
				materialCotadoEntity.getAlteradoPor());
		
		return materialCotadoModel;
	}
}
