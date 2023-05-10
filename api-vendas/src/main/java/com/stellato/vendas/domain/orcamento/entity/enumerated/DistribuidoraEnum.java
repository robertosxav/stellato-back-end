package com.stellato.vendas.domain.orcamento.entity.enumerated;

import com.stellato.vendas.exceptions.StellatoException;

public enum DistribuidoraEnum {
	ENERGISA_MT(0,"ENERGISA MT"),
	AMAZONAS_ENERGISA(1,"AMAZONAS ENERGISA"),
	CEA_EQUATORIAL(2,"CEA EQUATORIAL");
	
	private Integer numero;
	private String descricao;
	
	DistribuidoraEnum(Integer numero, String descricao) {
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
	
	public static DistribuidoraEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(DistribuidoraEnum s : DistribuidoraEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de enum inválido: "+numero);
	}
	
	public static DistribuidoraEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(DistribuidoraEnum s : DistribuidoraEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}
