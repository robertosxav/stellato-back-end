package com.stellato.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.model.enumerated.OrigemEnum;
import com.stellato.model.enumerated.StatusEnum;
import com.stellato.model.enumerated.TipoPessoaEnum;

@Entity
@Table(name = "lead") 
public class Lead implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SEQUENCE_LEAD")
	@SequenceGenerator(name = "SEQUENCE_LEAD",sequenceName = "seq_lead",allocationSize = 1)
	@Column(name = "lead_id")
	private Long id;

	@Column(name = "lead_nome")
	private String nome;

	@Column(name = "lead_telefone")
	private String telefone;

	@OneToOne()
	@JoinColumn(name = "pessoa_id",referencedColumnName = "pessoa_id")
	private Pessoa pessoa;

	@Column(name = "lead_whatsapp")
	private String whatsapp;

	@Column(name = "lead_email")
	private String email;

	@Column(name = "lead_cidade")
	private String cidade;

	@Column(name = "lead_origem")
	private OrigemEnum origem;

	@Column(name = "lead_tipo")
	private TipoPessoaEnum tipo;
	
	@Column(name = "lead_status")
	private StatusEnum status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "lead_criado_em")
	private LocalDate criadoEm;

	@Column(name = "lead_criado_por")
	private Integer criadoPor;

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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
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


	public OrigemEnum getOrigem() {
		return origem;
	}

	public void setOrigem(OrigemEnum origem) {
		this.origem = origem;
	}

	public TipoPessoaEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoaEnum tipo) {
		this.tipo = tipo;
	}

	public StatusEnum getStatus() {
		return status;
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
	
	public void ativar() {
		this.status = StatusEnum.ATIVO;
		this.criadoEm = LocalDate.now();
	}
	
	public void inativar() {
		this.status = StatusEnum.INATIVO;
	}

} 
