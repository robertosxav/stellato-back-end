package com.stellato.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.model.enumerated.ModalidadeTariariaEnum;
import com.stellato.model.enumerated.StatusEnum;
import com.stellato.model.enumerated.TipoPadraoEnum;

@Entity
@Table(name = "dados_conta_energia")
public class DadosContaEnergia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_DADOS_CONTA_ENERGIA")
	@SequenceGenerator(name = "SEQUENCE_DADOS_CONTA_ENERGIA",sequenceName = "seq_dados_conta_energia",allocationSize = 1)
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
	private TipoPadraoEnum tipoPadrao;

	@Column(name = "modalidade_tarifaria")
	private ModalidadeTariariaEnum modalidadeTarifa;
	
	@ManyToOne()
	@JoinColumn(name = "distribuidora_id",referencedColumnName  = "distribuidora_id")
	private Distribuidora distribuidora;

	@Column(name = "dados_conta_energia_preco_kwh")
	private BigDecimal precoKwh;

	@Column(name = "dados_conta_energia_consumo_medio")
	private BigDecimal consumoMedio;

	@Column(name = "dados_conta_status")
	private StatusEnum status;

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

	public TipoPadraoEnum getTipoPadrao() {
		return tipoPadrao;
	}

	public void setTipoPadrao(TipoPadraoEnum tipoPadrao) {
		this.tipoPadrao = tipoPadrao;
	}
	
	public ModalidadeTariariaEnum getModalidadeTarifa() {
		return modalidadeTarifa;
	}

	public void setModalidadeTarifa(ModalidadeTariariaEnum modalidadeTarifa) {
		this.modalidadeTarifa = modalidadeTarifa;
	}
	
	public Distribuidora getDistribuidora() {
		return distribuidora;
	}

	public void setDistribuidora(Distribuidora distribuidora) {
		this.distribuidora = distribuidora;
	}

	public BigDecimal getPrecoKwh() {
		return precoKwh;
	}

	public void setPrecoKwh(BigDecimal precoKwh) {
		this.precoKwh = precoKwh;
	}

	public BigDecimal getConsumoMedio() {
		return consumoMedio;
	}

	public void setConsumoMedio(BigDecimal consumoMedio) {
		this.consumoMedio = consumoMedio;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public LocalDate getCriadoEm() {
		return criadoEm;
	}

	public Integer getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Integer criadoPor) {
		this.criadoPor = criadoPor;
	}
	
	public void ativar() {
		this.status = StatusEnum.ATIVO;
		this.criadoEm = LocalDate.now();
	}
	
	public void inativar() {
		this.status = StatusEnum.INATIVO;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosContaEnergia other = (DadosContaEnergia) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "DadosContaEnergia [id=" + id + ", orcamentoEletrico=" + orcamentoEletrico + ", uc=" + uc
				+ ", descricaoUc=" + descricaoUc + ", tipoPadrao=" + tipoPadrao + ", modalidadeTarifa="
				+ modalidadeTarifa + ", precoKwh=" + precoKwh + ", consumoMedio=" + consumoMedio + ", status=" + status
				+ ", criadoEm=" + criadoEm + ", criadoPor=" + criadoPor + "]";
	}
	
}
