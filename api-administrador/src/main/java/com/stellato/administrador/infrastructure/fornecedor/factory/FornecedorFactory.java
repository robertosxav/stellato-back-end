package com.stellato.administrador.infrastructure.fornecedor.factory;

import org.springframework.stereotype.Component;

import com.stellato.administrador.domain.fornecedor.entity.FornecedorEntity;
import com.stellato.administrador.infrastructure.fornecedor.FornecedorModel;



@Component
public class FornecedorFactory {
	
	public FornecedorModel create (FornecedorEntity fornecedorEntity) {		
		FornecedorModel fornecedorModel = new FornecedorModel(fornecedorEntity.getId(),fornecedorEntity.getRazaoSocial(),fornecedorEntity.getCnpj(),
				fornecedorEntity.getStatus().getNumero(),fornecedorEntity.getCriadoEm(), fornecedorEntity.getCriadoPor(), fornecedorEntity.getAlteradoEm(),
				fornecedorEntity.getAlteradoPor());
		
		return fornecedorModel;
	}
}
