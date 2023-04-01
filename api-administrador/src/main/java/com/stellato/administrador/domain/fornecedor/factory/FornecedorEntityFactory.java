package com.stellato.administrador.domain.fornecedor.factory;

import org.springframework.stereotype.Component;

import com.stellato.administrador.domain.fornecedor.entity.FornecedorEntity;
import com.stellato.administrador.infrastructure.fornecedor.FornecedorModel;


@Component
public class FornecedorEntityFactory {
	
	public FornecedorEntity create (FornecedorModel fornecedorModel) {		
		
		FornecedorEntity fornecedorEntity = new FornecedorEntity(fornecedorModel.getId(),fornecedorModel.getCodigo(),fornecedorModel.getRazaoSocial(),
				fornecedorModel.getCnpj(),fornecedorModel.getStatus(), fornecedorModel.getCriadoEm(),fornecedorModel.getCriadoPor(), 
				fornecedorModel.getAlteradoEm(),fornecedorModel.getAlteradoPor());
		
		return fornecedorEntity;
	}
}
