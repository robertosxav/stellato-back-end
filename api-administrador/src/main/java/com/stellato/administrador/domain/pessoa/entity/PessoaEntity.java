package com.stellato.administrador.domain.pessoa.entity;

import java.time.LocalDate;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.administrador.domain.pessoa.entity.enumerated.TipoPessoaEnum;
import com.stellato.administrador.domain.shared.BaseEnityInterface;
import com.stellato.administrador.domain.shared.BaseEntity;
import com.stellato.administrador.domain.shared.enumerated.StatusEnum;
import com.stellato.administrador.exceptions.StellatoException;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PessoaEntity extends BaseEntity{

	private Long id;
	
	private String nome;
	
	private String cpf;
	
	private String nomeFantasia;
	
	private String cnpj;

	private String telefone;

	private String whatsApp;

	private String email;
	
	private TipoPessoaEnum tipoPessoa;
	
	@Transient
	private Boolean isForncededor = false;

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void SetId(Long id) {
		this.id = id;
	}

	@Override
	public Boolean validar() {
		if (this.nome.isEmpty()) {
			throw new StellatoException("Nome é obrigatório");
		}

		if (this.telefone.isEmpty()) {
			throw new StellatoException("Telefone é obrigatório");
		}
		
		if (this.whatsApp.isEmpty()) {
			throw new StellatoException("whatsApp é obrigatório");
		}

		if (this.cpf.isEmpty()) {
			throw new StellatoException("CPF é obrigatório");
		}

		return true;
	}



	public PessoaEntity(Long id, String codigo,String nome,  String cpf, String nomeFantasia, String cnpj,
			String telefone, String whatsApp, String email,Integer tipoPessoaNumero, Integer statusNumero,
			LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(codigo,statusNumero, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.tipoPessoa = TipoPessoaEnum.toEnum(tipoPessoaNumero);
	}
	
	

	public PessoaEntity(Long id, String codigo,String nome,  String cpf, String nomeFantasia, String cnpj,
			String telefone, String whatsApp, String email,Integer tipoPessoaNumero,LocalDate criadoEm,
			Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.tipoPessoa = TipoPessoaEnum.toEnum(tipoPessoaNumero);
	}
}
