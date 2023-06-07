package com.stellato.model.enumerated;

import com.stellato.exceptions.StellatoException;

public enum UnidadeMedidaEnum {
	KILO(0,"KILO"),
	METRO(1,"METRO"),
	METRO_QUADRADO(1,"METRO QUADRADO"),
	PECA(1,"PEÇA");
	
	private Integer numero;
	private String descricao;
	
	UnidadeMedidaEnum(Integer numero, String descricao) {
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
	
	public static UnidadeMedidaEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(UnidadeMedidaEnum s : UnidadeMedidaEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de Status inválido: "+numero);
	}
	
	public static UnidadeMedidaEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(UnidadeMedidaEnum s : UnidadeMedidaEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}