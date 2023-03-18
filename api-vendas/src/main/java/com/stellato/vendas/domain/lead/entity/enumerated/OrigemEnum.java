package com.stellato.vendas.domain.lead.entity.enumerated;

import com.stellato.vendas.exceptions.StellatoException;

public enum OrigemEnum {
	WHATSAPP(0,"WHATSAPP"),
	FACEBOOK(1,"FACEBOOK"),
	INSTAGRAM(2,"INSTAGRAM");
	
	private Integer numero;
	private String descricao;
	
	OrigemEnum(Integer numero, String descricao) {
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
	
	public static OrigemEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(OrigemEnum s : OrigemEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de Status inválido: "+numero);
	}
	
	public static OrigemEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(OrigemEnum s : OrigemEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}
