package com.stellato.vendas.domain.lead.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.vendas.domain.lead.entity.enumerated.OrigemEnum;
import com.stellato.vendas.domain.lead.entity.enumerated.TipoLeadEnum;
import com.stellato.vendas.domain.shared.BaseEntityInterface;
import com.stellato.vendas.domain.shared.BaseEntity;
import com.stellato.vendas.domain.shared.enumerated.StatusEnum;
import com.stellato.vendas.exceptions.StellatoException;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LeadEntity extends BaseEntity {

	private Long id;

	private String nome;

	private String telefone;

	private String whatsApp;

	private String email;

	private String cidade;

	private OrigemEnum origem;

	private TipoLeadEnum tipoLead;

	private Long idPessoa;
	
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void SetId(Long id) {
		this.id = id;
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


	public LeadEntity(Long id,String codigo, String nome, String telefone, String whatsApp, String email, String cidade,
			Integer origemNumero, Integer tipoLeadNumero, Long idPessoa, Integer statusNumero, LocalDate criadoEm, Long criadoPor,
			LocalDate alteradoEm, Long alteradoPor) {
		super(codigo,statusNumero, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.cidade = cidade;
		this.origem = OrigemEnum.toEnum(origemNumero);
		this.tipoLead = TipoLeadEnum.toEnum(tipoLeadNumero);
		this.idPessoa = idPessoa;
	}

	public LeadEntity(Long id,String codigo, String nome, String telefone, String whatsApp, String email, String cidade,
			Integer origemNumero, Integer tipoLeadNumero, Long idPessoa, LocalDate criadoEm, Long criadoPor, LocalDate alteradoEm,
			Long alteradoPor) {
		super(codigo, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.whatsApp = whatsApp;
		this.email = email;
		this.cidade = cidade;
		this.origem = OrigemEnum.toEnum(origemNumero);
		this.tipoLead = TipoLeadEnum.toEnum(tipoLeadNumero);
		this.idPessoa = idPessoa;
	}
	public LeadEntity(Long id,String nome, String telefone,String email, String whatsApp) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.whatsApp = whatsApp;
	}
}
