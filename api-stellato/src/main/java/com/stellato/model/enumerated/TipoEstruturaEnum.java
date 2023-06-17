package com.stellato.model.enumerated;

import com.stellato.exceptions.StellatoException;

public enum TipoEstruturaEnum {
	CERAMICO(0,"CERÂMICO"),
	PVC(1,"PVC");
	
	private Integer numero;
	private String descricao;
	
	TipoEstruturaEnum(Integer numero, String descricao) {
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
	
	public static TipoEstruturaEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(TipoEstruturaEnum s : TipoEstruturaEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de enum inválido: "+numero);
	}
	
	public static TipoEstruturaEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(TipoEstruturaEnum s : TipoEstruturaEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}