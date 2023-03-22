package com.stellato.vendas.domain.lead.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.vendas.domain.shared.enumerated.StatusEnum;
import com.stellato.vendas.exceptions.StellatoException;

public class LeadEntity implements LeadInterface {

	private Long id;

	private String nome;

	private String telefone;

	private String whatsApp;

	private String email;

	private String cidade;

	private Integer origem;

	private Integer tipoLead;

	private Long idPessoa;

	private StatusEnum status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate criadoEm;

	private Long criadoPor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate alteradoEm;

	private Long alteradoPor;

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void SetId(Long id) {
		this.id = id;
	}

	@Override
	public StatusEnum getStatus() {
		return this.status;
	}

	@Override
	public void setStatus(StatusEnum status) {
		this.status = status;

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

	public String getWhatsApp() {
		return whatsApp;
	}

	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
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

	public void Ativar() {
		this.status 	=	StatusEnum.ATIVO;
		this.criadoEm	=	LocalDate.now();		
	}
	
	public void Alterar(Long id) {
		this.status 	=	StatusEnum.ATIVO;
		this.alteradoEm	 =	LocalDate.now();	
		this.alteradoPor = id;
	}

	public void Inativar() {
		this.status = StatusEnum.INATIVO;
	}

	public Boolean validar() {
		if (this.nome.isEmpty()) {
			throw new StellatoException("Nome é obrigatório");
		}

		if (this.telefone.isEmpty()) {
			throw new StellatoException("Telefone é obrigatório");
		}
		
		if (this.whatsApp.isEmpty()) {
			throw new StellatoException("whatsApp é obrigatório");
		}

		if (this.cidade.isEmpty()) {
			throw new StellatoException("Cidade é obrigatório");
		}

		return true;
	}

	public LeadEntity() {
		super();
	}

	public LeadEntity(Long id, String nome, String telefone, String whatsApp, String email, String cidade,
			Integer origem, Integer tipoLead, Long idPessoa, Integer statusNumero, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.cidade = cidade;
		this.origem = origem;
		this.tipoLead = tipoLead;
		this.idPessoa = idPessoa;
		this.status = StatusEnum.toEnum(statusNumero);
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}

	public LeadEntity(Long id, String nome, String telefone, String whatsApp, String email, String cidade,
			Integer origem, Integer tipoLead, Long idPessoa, LocalDate criadoEm, Long criadoPor, LocalDate alteradoEm,
			Long alteradoPor) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.cidade = cidade;
		this.origem = origem;
		this.tipoLead = tipoLead;
		this.idPessoa = idPessoa;
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}

}
