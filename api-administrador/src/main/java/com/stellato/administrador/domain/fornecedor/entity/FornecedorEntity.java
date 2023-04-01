package com.stellato.administrador.domain.fornecedor.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.administrador.domain.shared.BaseEnityInterface;
import com.stellato.administrador.domain.shared.BaseEntity;
import com.stellato.administrador.domain.shared.enumerated.StatusEnum;
import com.stellato.administrador.exceptions.StellatoException;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class FornecedorEntity extends BaseEntity{

	private Long id;
	
	private String codigo;
	
	private String razaoSocial;
	
	private String cnpj;
	
	
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
		if (this.razaoSocial.isEmpty()) {
			throw new StellatoException("Razão Social é obrigatória");
		}
		
		if (this.getCnpj()==null) {
			throw new StellatoException("CNPJ é obrigatório");
		}
		return true;
	}
	
	public FornecedorEntity(Long id, String codigo, String razaoSocial, String cnpj, Integer statusNumero
			, LocalDate criadoEm,Long criadoPor, LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.codigo	= codigo;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;

	}
	
	public FornecedorEntity(Long id, String codigo, String razaoSocial, String cnpj, LocalDate criadoEm,
			Long criadoPor, LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.codigo = codigo;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;

	}

}
