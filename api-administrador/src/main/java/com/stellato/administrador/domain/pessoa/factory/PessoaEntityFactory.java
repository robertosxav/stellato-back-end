package com.stellato.administrador.domain.pessoa.factory;

import org.springframework.stereotype.Component;

import com.stellato.administrador.domain.pessoa.entity.PessoaEntity;
import com.stellato.administrador.infrastructure.pessoa.PessoaModel;

@Component
public class PessoaEntityFactory {
	
	public PessoaEntity create (PessoaModel pessoaModel) {		
		
		PessoaEntity pessoaEntity = new PessoaEntity(pessoaModel.getId(),pessoaModel.getCodigo(),pessoaModel.getNome(),
				pessoaModel.getCpf(),pessoaModel.getNomeFantasia(),pessoaModel.getCnpj(),pessoaModel.getTelefone(),
				pessoaModel.getWhatsapp(), pessoaModel.getEmail(),pessoaModel.getTipoPessoa(), pessoaModel.getStatus(),
				pessoaModel.getCriadoEm(),pessoaModel.getCriadoPor(),pessoaModel.getAlteradoEm(),pessoaModel.getAlteradoPor());
		
		return pessoaEntity;
	}
}