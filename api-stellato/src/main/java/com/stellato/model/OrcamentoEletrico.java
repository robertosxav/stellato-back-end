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
@Table(name = "orcamento_eletrico") 
public class OrcamentoEletrico implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "orcamento_eletrico_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "lead_id",referencedColumnName = "lead_id")
	private Lead lead;

	@Column(name = "orcamento_eletrico_titulo")
	private String titulo;

	@Column(name = "orcamento_eletrico_observacao")
	private String observacao;

	@Column(name = "orcamento_eletrico_observacao_int")
	private String observacaoInt;

	@Column(name = "orcamento_eletrico_validade_propo")
	private Integer validadeProposta;

	@Column(name = "orcamento_eletrico_prazo_entrega")
	private Integer prazoEntrega;

	@Column(name = "orcamento_eletrico_distancia")
	private Integer distancia;

	@Column(name = "orcamento_eletrico_detalhespropo")
	private String detalhesProposta;

	@Column(name = "orcamento_eletrico_tipo_instalaca")
	private Integer tipoInstalacao;

	@Column(name = "orcamento_eletrico_tipo_estrutura")
	private Integer tipoEstrutura;

	@ManyToOne
	@JoinColumn(name = "etapas_funil_id",referencedColumnName = "etapas_funil_id")
	private EtapasFunil etapasfunil;

	@Column(name = "etapas_funil_status")
	private Integer status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "etapas_funil_criado_em")
	private LocalDate criadoEm;

	@Column(name = "etapas_funil_criado_por")
	private Integer criadoPor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lead getLead() {
		return lead;
	}

	public void setLead(Lead lead) {
		this.lead = lead;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getObservacaoInt() {
		return observacaoInt;
	}

	public void setObservacaoInt(String observacaoInt) {
		this.observacaoInt = observacaoInt;
	}

	public Integer getValidadeProposta() {
		return validadeProposta;
	}

	public void setValidadeProposta(Integer validadeProposta) {
		this.validadeProposta = validadeProposta;
	}

	public Integer getPrazoEntrega() {
		return prazoEntrega;
	}

	public void setPrazoEntrega(Integer prazoEntrega) {
		this.prazoEntrega = prazoEntrega;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public String getDetalhesProposta() {
		return detalhesProposta;
	}

	public void setDetalhesProposta(String detalhesProposta) {
		this.detalhesProposta = detalhesProposta;
	}

	public Integer getTipoInstalacao() {
		return tipoInstalacao;
	}

	public void setTipoInstalacao(Integer tipoInstalacao) {
		this.tipoInstalacao = tipoInstalacao;
	}

	public Integer getTipoEstrutura() {
		return tipoEstrutura;
	}

	public void setTipoEstrutura(Integer tipoEstrutura) {
		this.tipoEstrutura = tipoEstrutura;
	}

	public EtapasFunil getEtapasfunil() {
		return etapasfunil;
	}

	public void setEtapasfunil(EtapasFunil etapasfunil) {
		this.etapasfunil = etapasfunil;
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