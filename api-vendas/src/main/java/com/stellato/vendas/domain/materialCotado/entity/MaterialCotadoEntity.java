package com.stellato.vendas.domain.materialCotado.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Embedded;

import com.stellato.vendas.domain.shared.BaseEntity;
import com.stellato.vendas.exceptions.StellatoException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MaterialCotadoEntity extends BaseEntity {
	
	private Long id;
	
	private String observacao;
	
	private BigDecimal valor;
	
	private Long idFornecedor;
	
	private String razaoSocial;
	
	private String cnpj;
	
	private Long idMaterial;
	
	private String descricaoMaterial;
	
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
		
		/*if (this.idFornecedor == null) {
			throw new StellatoException("Fornecedor é obrigatório");
		}*/
		
		if (this.idMaterial == null) {
			throw new StellatoException("Material é obrigatório");
		}
		
		return true;
	}
	
	public MaterialCotadoEntity(Long id, String codigo, String observacao, BigDecimal valor, Long idFornecedor, String razaoSocial,String cnpj, Long idMaterial, String descricaoMaterial,
			Integer statusNumero, LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(codigo,statusNumero, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.observacao	= observacao;
		this.valor = valor;
		this.idFornecedor = idFornecedor;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.idMaterial = idMaterial;
		this.descricaoMaterial = descricaoMaterial;
	}

	public MaterialCotadoEntity(Long id, String codigo, String observacao, BigDecimal valor,Long idFornecedor, String razaoSocial,String cnpj, Long idMaterial, String descricaoMaterial,
			LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.observacao	= observacao;
		this.valor = valor;
		this.idFornecedor = idFornecedor;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.idMaterial = idMaterial;
		this.descricaoMaterial = descricaoMaterial;
	}

}
