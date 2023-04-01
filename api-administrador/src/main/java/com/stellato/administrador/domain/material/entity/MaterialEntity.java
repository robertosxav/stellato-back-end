package com.stellato.administrador.domain.material.entity;

import java.time.LocalDate;

import com.stellato.administrador.domain.material.entity.enumerated.TipoMaterialEnum;
import com.stellato.administrador.domain.material.entity.enumerated.UnidadeMedidaEnum;
import com.stellato.administrador.domain.shared.BaseEntity;
import com.stellato.administrador.exceptions.StellatoException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MaterialEntity extends BaseEntity{

	private Long id;
	
	private String descricao;
	
	private TipoMaterialEnum tipo;
	
	private UnidadeMedidaEnum unidadeMedida;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void SetId(Long id) {
		this.id = id;
	}
	
	@Override
	public Boolean validar() {
		if (this.descricao.isEmpty()) {
			throw new StellatoException("Descrição é obrigatório");
		}
		
		if (this.getTipo()==null) {
			throw new StellatoException("Tipo do material é obrigatório");
		}
		
		if (this.getTipo()==null) {
			throw new StellatoException("Unidade de Medida é obrigatório");
		}
		return true;
	}

	public MaterialEntity(Long id, String codigo, String descricao, Integer tipoNumero,Integer unidadeMedidaNumero,
			Integer statusNumero,LocalDate criadoEm,Long criadoPor, LocalDate alteradoEm, Long alteradoPor) {
		super(codigo,statusNumero, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.descricao = descricao;
		this.tipo = TipoMaterialEnum.toEnum(tipoNumero);
		this.unidadeMedida = UnidadeMedidaEnum.toEnum(unidadeMedidaNumero);
	}
	
	public MaterialEntity(Long id, String codigo, String descricao, Integer tipoNumero, Integer unidadeMedidaNumero,
			LocalDate criadoEm,Long criadoPor, LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.descricao = descricao;
		this.tipo = TipoMaterialEnum.toEnum(tipoNumero);
		this.unidadeMedida = UnidadeMedidaEnum.toEnum(unidadeMedidaNumero);
	}

}
