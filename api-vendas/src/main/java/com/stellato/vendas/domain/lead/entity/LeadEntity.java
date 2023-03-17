package com.stellato.vendas.domain.lead.entity;

import java.math.BigDecimal;

import com.stellato.vendas.domain.shared.enumerated.StatusEnum;
import com.stellato.vendas.exceptions.StellatoException;

public class LeadEntity implements LeadInterface{
	
	private BigDecimal id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private BigDecimal consumo;
	
	private String cidade;
	
	private BigDecimal tipoTelha;
	
	private BigDecimal origem;
	
	private StatusEnum status;
	
	@Override
	public BigDecimal getId() {
		return this.id;
	}

	@Override
	public StatusEnum getStatus() {
		return this.status;
	}
	
	
	public void Ativar() {
		this.status =StatusEnum.ATIVO;
	}
	
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public BigDecimal getConsumo() {
		return consumo;
	}

	public String getCidade() {
		return cidade;
	}

	public BigDecimal getTipoTelha() {
		return tipoTelha;
	}

	public BigDecimal getOrigem() {
		return origem;
	}

	public void Inativar() {
		this.status =StatusEnum.INATIVO;
	}
	
	public Boolean validar(){
		if (this.nome.isEmpty()) {
			throw new StellatoException("Nome é obrigatório");
		}
		
		if (this.telefone.isEmpty()) {
			throw new StellatoException("Telefone é obrigatório");
		}
		
		if (this.cidade.isEmpty()) {
			throw new StellatoException("Cidade é obrigatório");
		}
		
		
		return true;
	}
	
	public LeadEntity(BigDecimal id, String nome, String email, String telefone, BigDecimal consumo, String cidade,
			BigDecimal tipoTelha, BigDecimal origem,Integer statusNumero) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.consumo = consumo;
		this.cidade = cidade;
		this.tipoTelha = tipoTelha;
		this.origem = origem;
		this.status = StatusEnum.toEnum(statusNumero);
	}
	
	public LeadEntity(BigDecimal id, String nome, String email, String telefone, BigDecimal consumo, String cidade,
			BigDecimal tipoTelha, BigDecimal origem) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.consumo = consumo;
		this.cidade = cidade;
		this.tipoTelha = tipoTelha;
		this.origem = origem;
	}

	public LeadEntity() {
		super();
	}	
	
}
