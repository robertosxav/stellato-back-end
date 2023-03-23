package com.stellato.administrador.domain.material.entity.enumerated;

import com.stellato.administrador.exceptions.StellatoException;

public enum TipoMaterialEnum {
	INDIVIUAL(0,"INDIVIUAL"),
	KIT(1,"KIT");
	
	private Integer numero;
	private String descricao;
	
	TipoMaterialEnum(Integer numero, String descricao) {
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
	
	public static TipoMaterialEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(TipoMaterialEnum s : TipoMaterialEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de Status inválido: "+numero);
	}
	
	public static TipoMaterialEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(TipoMaterialEnum s : TipoMaterialEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}
