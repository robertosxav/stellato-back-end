package com.stellato.vendas.infrastructure.historicoLead;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.vendas.domain.shared.enumerated.StatusEnum;
import com.stellato.vendas.infrastructure.lead.LeadModel;


@Table(name = "TB_HISTORICO_LEAD")
@Entity
public class HistoricoLeadModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_HIST_LEAD")
	//@SequenceGenerator(name = "SEQUENCE_HIS_LEAD",sequenceName = "tb_historico_lead_seq",allocationSize = 1)
	@Column(name = "ID_HIST_LEAD")
	private BigDecimal id;
	
	private String decricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	private StatusEnum status;
	
	//@ManyToOne()
	//O@JoinColumn(name = "ID_LEAD",referencedColumnName = "ID_LEAD")
	private LeadModel lead;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getDecricao() {
		return decricao;
	}

	public void setDecricao(String decricao) {
		this.decricao = decricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public LeadModel getLead() {
		return lead;
	}

	public void setLead(LeadModel lead) {
		this.lead = lead;
	}

	public HistoricoLeadModel(BigDecimal id, String decricao, LocalDate data, StatusEnum status, LeadModel lead) {
		super();
		this.id = id;
		this.decricao = decricao;
		this.data = data;
		this.status = status;
		this.lead = lead;
	}
	
	public HistoricoLeadModel(String decricao, LocalDate data, StatusEnum status, LeadModel lead) {
		super();
		this.decricao = decricao;
		this.data = data;
		this.status = status;
		this.lead = lead;
	}

	public HistoricoLeadModel() {
		super();
	}
	
}
