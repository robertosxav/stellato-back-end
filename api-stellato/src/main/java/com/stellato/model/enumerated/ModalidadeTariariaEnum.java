package com.stellato.model.enumerated;

import com.stellato.exceptions.StellatoException;

public enum ModalidadeTariariaEnum {
	GRUPO_B_CONVENCIONAL(0,"Grupo B Convencional"),
	GRUPO_A_VERDE(0,"Grupo A Verde"),
	GRUPO_A_AZUL(0,"Grupo A Azul"),;
	
	private Integer numero;
	private String descricao;
	
	ModalidadeTariariaEnum(Integer numero, String descricao) {
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
	
	public static ModalidadeTariariaEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(ModalidadeTariariaEnum s : ModalidadeTariariaEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de enum inválido: "+numero);
	}
	
	public static ModalidadeTariariaEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(ModalidadeTariariaEnum s : ModalidadeTariariaEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}