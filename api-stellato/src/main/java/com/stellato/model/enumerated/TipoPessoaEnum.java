package com.stellato.model.enumerated;

import com.stellato.exceptions.StellatoException;

public enum TipoPessoaEnum {

	PESSOA_FISICA(0,"PESSOA FÍSICA"),
	PESSOA_JURIDICA(1,"PESSOA JURÍDICA");
	
	private Integer numero;
	private String descricao;
	
	TipoPessoaEnum(Integer numero, String descricao) {
		this.numero	=	numero;
		this.descricao	=	descricao;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoPessoaEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(TipoPessoaEnum s : TipoPessoaEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de Status inválido: "+numero);
	}
	
	public static TipoPessoaEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(TipoPessoaEnum s : TipoPessoaEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}
