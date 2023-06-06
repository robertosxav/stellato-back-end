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
@Table(name = "orcamento_ele_arquivo") 
public class OrcamentoEleArquivo implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "orcamento_ele_arquivo_id")
	private Long id;

	@ManyToOne()
	@JoinColumn(name = "orcamento_eletrico_id",referencedColumnName = "orcamento_eletrico_id")
	private OrcamentoEletrico orcamentoEletrico;

	@ManyToOne()
	@JoinColumn(name = "arquivo_id",referencedColumnName = "arquivo_id")
	private Arquivo arquivo;

	@Column(name = "orcamento_ele_arquivo_status")
	private Integer status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "orcamento_ele_arquivo_criado_em")
	private LocalDate criadoEm;

	@Column(name = "orcamento_ele_arquivo_criado_por")
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

	public Arquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
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