package com.stellato.model;

import java.io.Serializable;
import java.time.LocalDate;

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
import com.stellato.model.enumerated.StatusEnum;
import com.stellato.model.enumerated.TipoEstruturaEnum;
import com.stellato.model.enumerated.TipoInstalacaoEnum;

@Entity
@Table(name = "orcamento_eletrico") 
public class OrcamentoEletrico implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_ORCAMENTO_ELETRICO")
	@SequenceGenerator(name = "SEQUENCE_ORCAMENTO_ELETRICO",sequenceName = "seq_orcamento_eletrico",allocationSize = 1)
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
	private TipoInstalacaoEnum tipoInstalacao;

	@Column(name = "orcamento_eletrico_tipo_estrutura")
	private TipoEstruturaEnum tipoEstrutura;

	@ManyToOne
	@JoinColumn(name = "etapas_funil_id",referencedColumnName = "etapas_funil_id")
	private EtapasFunil etapasfunil;

	@Column(name = "etapas_funil_status")
	private StatusEnum status;

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


	public TipoInstalacaoEnum getTipoInstalacao() {
		return tipoInstalacao;
	}

	public void setTipoInstalacao(TipoInstalacaoEnum tipoInstalacao) {
		this.tipoInstalacao = tipoInstalacao;
	}

	public TipoEstruturaEnum getTipoEstrutura() {
		return tipoEstrutura;
	}

	public void setTipoEstrutura(TipoEstruturaEnum tipoEstrutura) {
		this.tipoEstrutura = tipoEstrutura;
	}

	public EtapasFunil getEtapasfunil() {
		return etapasfunil;
	}

	public void setEtapasfunil(EtapasFunil etapasfunil) {
		this.etapasfunil = etapasfunil;
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
} 