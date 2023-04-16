package com.stellato.vendas.domain.materialCotado.factory;

import org.springframework.stereotype.Component;

import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;
import com.stellato.vendas.infrastructure.materialCotado.model.MaterialCotadoModel;



@Component
public class MaterialCotadoEntityFactory {
	
	public MaterialCotadoEntity create (MaterialCotadoModel materialCotadoModel) {		
		
		MaterialCotadoEntity materialCotadoEntity = new MaterialCotadoEntity(materialCotadoModel.getId(), materialCotadoModel.getCodigo(),materialCotadoModel.getObservacao(),
				materialCotadoModel.getValor(),materialCotadoModel.getIdFornecedor(),materialCotadoModel.getRazaoSocial(),materialCotadoModel.getCnpj(),materialCotadoModel.getIdMaterial(),
				materialCotadoModel.getDescricaoMaterial(),materialCotadoModel.getStatus(), materialCotadoModel.getCriadoEm(),materialCotadoModel.getCriadoPor(), materialCotadoModel.getAlteradoEm(),materialCotadoModel.getAlteradoPor());
		
		return materialCotadoEntity;
	}
}
