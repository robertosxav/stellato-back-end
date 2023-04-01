package com.stellato.administrador.domain.pessoa.entity;

import java.time.LocalDate;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.administrador.domain.pessoa.entity.enumerated.TipoPessoaEnum;
import com.stellato.administrador.domain.shared.BaseEnityInterface;
import com.stellato.administrador.domain.shared.enumerated.StatusEnum;
import com.stellato.administrador.exceptions.StellatoException;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PessoaEntity implements  BaseEnityInterface{

	private Long id;

	private String codigo;
	
	private String nome;
	
	private String cpf;
	
	private String nomeFantasia;
	
	private String cnpj;

	private String telefone;

	private String whatsApp;

	private String email;
	
	private TipoPessoaEnum tipoPessoa;

	private StatusEnum status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate criadoEm;

	private Long criadoPor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate alteradoEm;

	private Long alteradoPor;
	
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
	public StatusEnum getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(StatusEnum status) {
		this.status = status;

	}

	@Override
	public void Ativar() {
		this.status 	=	StatusEnum.ATIVO;
		this.criadoEm	=	LocalDate.now();		
	}
	
	@Override
	public void Alterar(Long id) {
		this.status 	=	StatusEnum.ATIVO;
		this.alteradoEm	 =	LocalDate.now();	
		this.alteradoPor = id;
	}

	@Override
	public void Inativar() {
		this.status = StatusEnum.INATIVO;
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
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.tipoPessoa = TipoPessoaEnum.toEnum(tipoPessoaNumero);
		this.status = StatusEnum.toEnum(statusNumero);
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}
	
	

	public PessoaEntity(Long id, String codigo,String nome,  String cpf, String nomeFantasia, String cnpj,
			String telefone, String whatsApp, String email,Integer tipoPessoaNumero,LocalDate criadoEm,
			Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.nome = nome;
		this.cpf = cpf;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.tipoPessoa = TipoPessoaEnum.toEnum(tipoPessoaNumero);
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}


}
