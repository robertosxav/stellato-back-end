package com.stellato.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "dados_conta_energia")
public class DadosContaEnergia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "dados_conta_energia_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "orcamento_eletrico_id", referencedColumnName = "orcamento_eletrico_id")
	private OrcamentoEletrico orcamentoEletrico;

	@Column(name = "dados_conta_energia_uc")
	private String uc;

	@Column(name = "dados_conta_energia_descricao_uc")
	private String descricaoUc;

	@Column(name = "dados_conta_energia_tipo_padrao")
	private Integer tipoPadrao;

	@Column(name = "dados_conta_energia_mod_tarifa")
	private Integer modalidadeTarifa;

	@Column(name = "dados_conta_energia_preco_kwh")
	private String precoKwh;

	@Column(name = "dados_conta_energia_consumo_medio")
	private String consumoMedio;

	@Column(name = "dados_conta_status")
	private Integer status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dados_conta_criado_em")
	private LocalDate criadoEm;

	@Column(name = "dados_conta_criado_por")
	private Integer criadoPor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OrcamentoEletrico getOrcamentoEletrico() {
		return orcamentoEletrico;
	}

	public void setOrcamentoEletrico(OrcamentoEletrico orcamentoEletrico) {
		this.orcamentoEletrico = orcamentoEletrico;
	}

	public String getUc() {
		return uc;
	}

	public void setUc(String uc) {
		this.uc = uc;
	}

	public String getDescricaoUc() {
		return descricaoUc;
	}

	public void setDescricaoUc(String descricaoUc) {
		this.descricaoUc = descricaoUc;
	}

	public Integer getTipoPadrao() {
		return tipoPadrao;
	}

	public void setTipoPadrao(Integer tipoPadrao) {
		this.tipoPadrao = tipoPadrao;
	}

	public Integer getModalidadeTarifa() {
		return modalidadeTarifa;
	}

	public void setModalidadeTarifa(Integer modalidadeTarifa) {
		this.modalidadeTarifa = modalidadeTarifa;
	}

	public String getPrecoKwh() {
		return precoKwh;
	}

	public void setPrecoKwh(String precoKwh) {
		this.precoKwh = precoKwh;
	}

	public String getConsumoMedio() {
		return consumoMedio;
	}

	public void setConsumoMedio(String consumoMedio) {
		this.consumoMedio = consumoMedio;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDate getCriadoEm() {
		return criadoEm;
	}

	public void setCriadoEm(LocalDate criadoEm) {
		this.criadoEm = criadoEm;
	}

	public Integer getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Integer criadoPor) {
		this.criadoPor = criadoPor;
	}

}
