package com.stellato.administrador.domain.material.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.administrador.domain.material.entity.enumerated.TipoMaterialEnum;
import com.stellato.administrador.domain.material.entity.enumerated.UnidadeMedidaEnum;
import com.stellato.administrador.domain.shared.BaseEnityInterface;
import com.stellato.administrador.domain.shared.enumerated.StatusEnum;
import com.stellato.administrador.exceptions.StellatoException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MaterialEntity implements BaseEnityInterface{

	private Long id;
	
	private String codigo;
	
	private String descricao;
	
	private TipoMaterialEnum tipo;
	
	private UnidadeMedidaEnum unidadeMedida;
	
	private StatusEnum status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate criadoEm;

	private Long criadoPor;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate alteradoEm;

	private Long alteradoPor;
	
	@Override
	public Long getId() {
		return id;
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
	public Boolean validar() {
		if (this.descricao.isEmpty()) {
			throw new StellatoException("Descrição é obrigatório");
		}
		
		if (this.getTipo()==null) {
			throw new StellatoException("Tipo do material é obrigatório");
		}
		return true;
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

	public MaterialEntity(Long id, String codigo, String descricao, Integer tipoNumero,Integer unidadeMedidaNumero,
			Integer statusNumero,LocalDate criadoEm,Long criadoPor, LocalDate alteradoEm, Long alteradoPor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = TipoMaterialEnum.toEnum(tipoNumero);
		this.unidadeMedida = UnidadeMedidaEnum.toEnum(unidadeMedidaNumero);
		this.status = StatusEnum.toEnum(statusNumero);
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}
	
	public MaterialEntity(Long id, String codigo, String descricao, Integer tipoNumero, Integer unidadeMedidaNumero,
			LocalDate criadoEm,Long criadoPor, LocalDate alteradoEm, Long alteradoPor) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descricao = descricao;
		this.tipo = TipoMaterialEnum.toEnum(tipoNumero);
		this.unidadeMedida = UnidadeMedidaEnum.toEnum(unidadeMedidaNumero);
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}

}
