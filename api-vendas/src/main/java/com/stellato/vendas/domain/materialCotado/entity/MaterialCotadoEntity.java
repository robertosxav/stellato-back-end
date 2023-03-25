package com.stellato.vendas.domain.materialCotado.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.vendas.domain.lead.entity.enumerated.OrigemEnum;
import com.stellato.vendas.domain.lead.entity.enumerated.TipoLead;
import com.stellato.vendas.domain.shared.BaseEnityInterface;
import com.stellato.vendas.domain.shared.enumerated.StatusEnum;
import com.stellato.vendas.exceptions.StellatoException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MaterialCotadoEntity implements BaseEnityInterface {
	
	private Long id;
	
	private String observacao;
	
	private BigDecimal valor;
	
	private Long idFornecedor;
	
	private Long idMaterial;
	
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
	
		if (this.observacao.isEmpty()) {
		}
		
		if (this.valor == null) {
			throw new StellatoException("Valor é obrigatório");
		}

		if (this.valor.compareTo(new BigDecimal(0))==0) {
			throw new StellatoException("Valor deve ser maior que zero");
		}
		
		if (this.idFornecedor == null) {
			throw new StellatoException("Fornecedor é obrigatório");
		}
		
		if (this.idMaterial == null) {
			throw new StellatoException("Material é obrigatório");
		}
		
		return true;
	}
	
	public MaterialCotadoEntity(Long id, String observacao, BigDecimal valor, Long idFornecedor, Long idMaterial,Integer statusNumero, 
			LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super();
		this.id = id;
		this.observacao	= observacao;
		this.valor = valor;
		this.idFornecedor = idFornecedor;
		this.idMaterial = idMaterial;
		this.status = StatusEnum.toEnum(statusNumero);
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}

	public MaterialCotadoEntity(Long id, String observacao, BigDecimal valor, Long idFornecedor, Long idMaterial,
			LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super();
		this.id = id;
		this.observacao	= observacao;
		this.valor = valor;
		this.idFornecedor = idFornecedor;
		this.idMaterial = idMaterial;
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}

}
