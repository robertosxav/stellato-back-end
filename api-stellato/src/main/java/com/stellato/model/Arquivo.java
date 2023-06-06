package com.stellato.model;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "arquivo") 
public class Arquivo implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "arquivo_id")
	private Long id;

	@Column(name = "arquivo_nome")
	private String nomeArquivo;

	@Column(name = "arquivo_extensao")
	private String extensao;

	@Column(name = "arquivo_blob")
	private Blob blob;
	
	@Column(name = "arquivo_status")
	private Integer status;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "arquivo_criado_em")
	private LocalDate criadoEm;
	
	@Column(name = "arquivo_criado_por")
	private Integer criadoPor;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getExtensao() {
		return extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Blob getBlob() {
		return blob;
	}

	public void setBlob(Blob blob) {
		this.blob = blob;
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
		Arquivo other = (Arquivo) obj;
		return Objects.equals(id, other.id);
	}

	

} 
