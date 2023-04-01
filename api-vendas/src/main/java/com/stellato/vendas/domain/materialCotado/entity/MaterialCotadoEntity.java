package com.stellato.vendas.domain.materialCotado.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.stellato.vendas.domain.shared.BaseEntity;
import com.stellato.vendas.exceptions.StellatoException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MaterialCotadoEntity extends BaseEntity {
	
	private Long id;
	
	private String observacao;
	
	private BigDecimal valor;
	
	private Long idFornecedor;
	
	private Long idMaterial;
	
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
	}

	public MaterialCotadoEntity(Long id, String observacao, BigDecimal valor, Long idFornecedor, Long idMaterial,
			LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super();
		this.id = id;
		this.observacao	= observacao;
		this.valor = valor;
		this.idFornecedor = idFornecedor;
		this.idMaterial = idMaterial;
	}

}
