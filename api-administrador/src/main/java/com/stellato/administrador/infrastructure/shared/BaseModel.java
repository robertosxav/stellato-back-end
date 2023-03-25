package com.stellato.administrador.infrastructure.shared;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel {
	
	private Integer status;
	
	private LocalDate criadoEm;
	
	private Long criadoPor;
	
	private LocalDate alteradoEm;
	
	private Long alteradoPor;

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

	public BaseModel(Integer status, LocalDate criadoEm, Long criadoPor, LocalDate alteradoEm, Long alteradoPor) {
		super();
		this.status = status;
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}

	public BaseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
