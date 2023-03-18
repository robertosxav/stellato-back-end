package com.stellato.vendas.domain.lead.entity.enumerated;

import com.stellato.vendas.exceptions.StellatoException;

public enum TipoTelhaEnum {
	
	CERAMICA(0,"TELHA DE CERÂMICA"),
	PVC(1,"TELHA DE PVC"),
	CONCRETO(2,"TELHA DE CONCRETO"),
	ECOLOGICAS(2,"TELHAS ECOLÓGICAS");
	
	private Integer numero;
	private String descricao;
	
	TipoTelhaEnum(Integer numero, String descricao) {
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
	
	public static TipoTelhaEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(TipoTelhaEnum s : TipoTelhaEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de Status inválido: "+numero);
	}
	
	public static TipoTelhaEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(TipoTelhaEnum s : TipoTelhaEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}
