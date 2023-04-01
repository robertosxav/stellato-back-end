package com.stellato.administrador.infrastructure.material.factory;

import org.springframework.stereotype.Component;

import com.stellato.administrador.domain.material.entity.MaterialEntity;
import com.stellato.administrador.infrastructure.material.MaterialModel;


@Component
public class MaterialFactory {
	
	public MaterialModel create (MaterialEntity materialEntity) {		
		MaterialModel MaterialModel = new MaterialModel(materialEntity.getId(),materialEntity.getCodigo(),materialEntity.getDescricao(),materialEntity.getTipo().getNumero(),
				materialEntity.getUnidadeMedida().getNumero(),materialEntity.getStatus().getNumero(),materialEntity.getCriadoEm(), materialEntity.getCriadoPor(),
				materialEntity.getAlteradoEm(), materialEntity.getAlteradoPor());
		
		return MaterialModel;
	}
}
