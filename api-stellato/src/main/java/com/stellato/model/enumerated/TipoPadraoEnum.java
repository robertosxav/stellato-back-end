package com.stellato.model.enumerated;

import com.stellato.exceptions.StellatoException;

public enum TipoPadraoEnum {
	MONOFASICO(0,"MONOFÁSICO"),
	BIFASICO(1,"BIFÁSICO");
	
	private Integer numero;
	private String descricao;
	
	TipoPadraoEnum(Integer numero, String descricao) {
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
	
	public static TipoPadraoEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(TipoPadraoEnum s : TipoPadraoEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de enum inválido: "+numero);
	}
	
	public static TipoPadraoEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(TipoPadraoEnum s : TipoPadraoEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}