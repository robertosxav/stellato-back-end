package com.stellato.vendas.infrastructure.lead;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "TB_LEAD")
@Entity
//@Getter
//@Setter
public class LeadModel implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_LEAD")
	@SequenceGenerator(name = "SEQUENCE_LEAD",sequenceName = "tb_lead_seq",allocationSize = 1)
	@Column(name = "ID_LEAD")
	private BigDecimal id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private BigDecimal consumo;
	
	private String cidade;
	
	private Integer tipoTelha;
	
	private Integer origem;
	
	private Integer status;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public BigDecimal getConsumo() {
		return consumo;
	}

	public void setConsumo(BigDecimal consumo) {
		this.consumo = consumo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getTipoTelha() {
		return tipoTelha;
	}

	public void setTipoTelha(Integer tipoTelha) {
		this.tipoTelha = tipoTelha;
	}

	public Integer getOrigem() {
		return origem;
	}

	public void setOrigem(Integer origem) {
		this.origem = origem;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LeadModel(BigDecimal id, String nome, String email, String telefone, BigDecimal consumo,
			String cidade,Integer tipoTelha, Integer origem, Integer status) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.consumo = consumo;
		this.cidade = cidade;
		this.tipoTelha = tipoTelha;
		this.origem = origem;
		this.status = status;
	}
	
	
	public LeadModel(String nome, String email, String telefone, BigDecimal consumo
			,String cidade,Integer tipoTelha, Integer origem, Integer status) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.consumo = consumo;
		this.cidade = cidade;
		this.tipoTelha = tipoTelha;
		this.origem = origem;
		this.status = status;
	}

	public LeadModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
