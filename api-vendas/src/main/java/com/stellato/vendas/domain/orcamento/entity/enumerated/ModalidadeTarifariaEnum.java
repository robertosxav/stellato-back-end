package com.stellato.vendas.domain.orcamento.entity.enumerated;

import com.stellato.vendas.exceptions.StellatoException;

public enum ModalidadeTarifariaEnum {
	CONVENCIONAL(0,"Grupo B - Convencional"),
	TARIFA_VERDE(1,"Grupo A - Tarifa Verde"),
	TARIFA_AZUL(2,"Grupo A - Tarifa Verde");
		
	private Integer numero;
	private String descricao;
	
	ModalidadeTarifariaEnum(Integer numero, String descricao) {
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
	
	public static ModalidadeTarifariaEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(ModalidadeTarifariaEnum s : ModalidadeTarifariaEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de enum inválido: "+numero);
	}
	
	public static ModalidadeTarifariaEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(ModalidadeTarifariaEnum s : ModalidadeTarifariaEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}
