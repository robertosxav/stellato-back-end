package com.stellato.administrador.infrastructure.pessoa.factory;

import org.springframework.stereotype.Component;

import com.stellato.administrador.domain.pessoa.entity.PessoaEntity;
import com.stellato.administrador.infrastructure.pessoa.PessoaModel;



@Component
public class PessoaFactory {
	
	public PessoaModel create (PessoaEntity pessoaEntity) {		
		PessoaModel PessoaModel = new PessoaModel(pessoaEntity.getId(), pessoaEntity.getNome(),pessoaEntity.getCpf(),
				pessoaEntity.getNomeFantasia(),pessoaEntity.getCnpj(),pessoaEntity.getTelefone(), pessoaEntity.getWhatsApp(),
				pessoaEntity.getEmail(), pessoaEntity.getCidade(),pessoaEntity.getStatus().getNumero(), pessoaEntity.getCriadoEm(), 
				pessoaEntity.getCriadoPor(), pessoaEntity.getAlteradoEm(),  pessoaEntity.getAlteradoPor());
		
		return PessoaModel;
	}
}