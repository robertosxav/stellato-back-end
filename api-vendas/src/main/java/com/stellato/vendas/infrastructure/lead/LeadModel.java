package com.stellato.vendas.infrastructure.lead;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.vendas.infrastructure.lead.shared.BaseModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name = "TB_LEAD",schema = "VENDAS")
@Entity
//@Getter
//@Setter
public class LeadModel extends BaseModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_LEAD")
	@SequenceGenerator(name = "SEQUENCE_LEAD",sequenceName = "vendas.tb_lead_seq",allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	private String nome;
	
	private String telefone;
	
	private String whatsapp;
	
	private String email;
	
	private String cidade;
	
	private Integer origem;
	
	private Integer tipoLead;
	
	private Long idPessoa;
	
	private Integer status;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate criadoEm;
	
	private Long criadoPor;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate alteradoEm;
	
	private Long alteradoPor;

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getwhatsapp() {
		return whatsapp;
	}


	public void setwhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public Integer getOrigem() {
		return origem;
	}


	public void setOrigem(Integer origem) {
		this.origem = origem;
	}


	public Integer getTipoLead() {
		return tipoLead;
	}


	public void setTipoLead(Integer tipoLead) {
		this.tipoLead = tipoLead;
	}


	public Long getidPessoa() {
		return idPessoa;
	}


	public void setidPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
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
	
	public LeadModel() {
		super();
	
	}


	public LeadModel(Long id, String nome, String telefone, String whatsapp, String email, String cidade,
			Integer origem, Integer tipoLead, Long idPessoa, Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.whatsapp = whatsapp;
		this.email = email;
		this.cidade = cidade;
		this.origem = origem;
		this.tipoLead = tipoLead;
		this.idPessoa = idPessoa;
		this.status = status;
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}
	
	public LeadModel(String nome, String telefone, String whatsapp, String email, String cidade,
			Integer origem, Integer tipoLead, Long idPessoa, Integer status, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.whatsapp = whatsapp;
		this.email = email;
		this.cidade = cidade;
		this.origem = origem;
		this.tipoLead = tipoLead;
		this.idPessoa = idPessoa;
		this.status = status;
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}


	@Override
	public String toString() {
		return "LeadModel [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", whatsapp=" + whatsapp
				+ ", email=" + email + ", cidade=" + cidade + ", origem=" + origem + ", tipoLead=" + tipoLead
				+ ", idPessoa=" + idPessoa + ", status=" + status + ", criadoEm=" + criadoEm + ", criadoPor="
				+ criadoPor + ", alteradoEm=" + alteradoEm + ", alteradoPor=" + alteradoPor + "]";
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
		LeadModel other = (LeadModel) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
