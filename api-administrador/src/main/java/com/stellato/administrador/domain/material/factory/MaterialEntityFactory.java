package com.stellato.administrador.domain.material.factory;

import org.springframework.stereotype.Component;

import com.stellato.administrador.domain.material.entity.MaterialEntity;
import com.stellato.administrador.infrastructure.material.MaterialModel;

@Component
public class MaterialEntityFactory {
	
	public MaterialEntity create (MaterialModel materialModel) {		
		
		MaterialEntity materialEntity = new MaterialEntity(materialModel.getId(),materialModel.getDescricao(),
				materialModel.getStatus(), materialModel.getCriadoEm(),materialModel.getCriadoPor(), 
				materialModel.getAlteradoEm(),materialModel.getAlteradoPor());
		
		return materialEntity;
	}
}
