package com.stellato.vendas.domain.lead.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.vendas.domain.lead.entity.enumerated.OrigemEnum;
import com.stellato.vendas.domain.lead.entity.enumerated.TipoLead;
import com.stellato.vendas.domain.shared.enumerated.StatusEnum;
import com.stellato.vendas.exceptions.StellatoException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LeadEntity implements LeadInterface {

	private Long id;

	private String nome;

	private String telefone;

	private String whatsApp;

	private String email;

	private String cidade;

	private OrigemEnum origem;

	private TipoLead tipoLead;

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

	@Override
	public void Ativar() {
		this.status 	=	StatusEnum.ATIVO;
		this.criadoEm	=	LocalDate.now();		
	}
	
	@Override
	public void Alterar(Long id) {
		this.status 	=	StatusEnum.ATIVO;
		this.alteradoEm	 =	LocalDate.now();	
		this.alteradoPor = id;
	}

	@Override
	public void Inativar() {
		this.status = StatusEnum.INATIVO;
	}

	@Override
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


	public LeadEntity(Long id, String nome, String telefone, String whatsApp, String email, String cidade,
			Integer origemNumero, Integer tipoLeadNumero, Long idPessoa, Integer statusNumero, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.cidade = cidade;
		this.origem = OrigemEnum.toEnum(origemNumero);
		this.tipoLead = TipoLead.toEnum(tipoLeadNumero);
		this.idPessoa = idPessoa;
		this.status = StatusEnum.toEnum(statusNumero);
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}

	public LeadEntity(Long id, String nome, String telefone, String whatsApp, String email, String cidade,
			Integer origemNumero, Integer tipoLeadNumero, Long idPessoa, LocalDate criadoEm, Long criadoPor, LocalDate alteradoEm,
			Long alteradoPor) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.cidade = cidade;
		this.origem = OrigemEnum.toEnum(origemNumero);
		this.tipoLead = TipoLead.toEnum(tipoLeadNumero);
		this.idPessoa = idPessoa;
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}

}
