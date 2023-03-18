package com.stellato.vendas.domain.lead.entity;

import java.math.BigDecimal;

import com.stellato.vendas.domain.lead.entity.enumerated.OrigemEnum;
import com.stellato.vendas.domain.lead.entity.enumerated.TipoTelhaEnum;
import com.stellato.vendas.domain.shared.enumerated.StatusEnum;
import com.stellato.vendas.exceptions.StellatoException;

public class LeadEntity implements LeadInterface{
	
	private BigDecimal id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private BigDecimal consumo;
	
	private String cidade;
	
	private TipoTelhaEnum tipoTelha;
	
	private OrigemEnum origem;
	
	private StatusEnum status;
	
	@Override
	public BigDecimal getId() {
		return this.id;
	}
	
	@Override
	public void SetId(BigDecimal id) {
		this.id	=	id;
	}	

	@Override
	public StatusEnum getStatus() {
		return this.status;
	}
	
	@Override
	public void setStatus(StatusEnum status) {
		this.status = status;
		
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

	public TipoTelhaEnum getTipoTelha() {
		return tipoTelha;
	}

	public OrigemEnum getOrigem() {
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
			Integer tipoTelhaNumero,Integer origemNumero,Integer statusNumero) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.consumo = consumo;
		this.cidade = cidade;
		this.tipoTelha = TipoTelhaEnum.toEnum(tipoTelhaNumero);
		this.origem = OrigemEnum.toEnum(origemNumero);
		this.status = StatusEnum.toEnum(statusNumero);
	}
	
	public LeadEntity(BigDecimal id, String nome, String email, String telefone, BigDecimal consumo, String cidade,
			Integer tipoTelhaNumero, Integer origemNumero) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.consumo = consumo;
		this.cidade = cidade;
		this.tipoTelha = TipoTelhaEnum.toEnum(tipoTelhaNumero);
		this.origem = OrigemEnum.toEnum(origemNumero);
	}

	public LeadEntity() {
		super();
	}
	
}
