package com.stellato.vendas.infrastructure.lead.shared;

import java.time.LocalDate;

import jakarta.persistence.Id;

public class BaseModel {
	
	@Id
	private Long id;
	
	private Integer status;
	
	private LocalDate criadoEm;
	
	private Long criadoPor;
	
	private LocalDate alteradoEm;
	
	private Long alteradoPor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getCriadoPor() {
		return criadoPor;
	}

	public void setCriadoPor(Long criadoPor) {
		this.criadoPor = criadoPor;
	}

	public LocalDate getAlteradoEm() {
		return alteradoEm;
	}

	public void setAlteradoEm(LocalDate alteradoEm) {
		this.alteradoEm = alteradoEm;
	}

	public Long getAlteradoPor() {
		return alteradoPor;
	}

	public void setAlteradoPor(Long alteradoPor) {
		this.alteradoPor = alteradoPor;
	}
	
	
}
