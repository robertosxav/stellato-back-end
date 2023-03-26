package com.stellato.vendas.domain.orcamento.entity.enumerated;

import com.stellato.vendas.exceptions.StellatoException;

public enum TipoInstalacaoEnum {
	RESIDENCIAL(0,"RESIDENCIAL"),
	PREDIAL(1,"PREDIAL");
	
	private Integer numero;
	private String descricao;
	
	TipoInstalacaoEnum(Integer numero, String descricao) {
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
	
	public static TipoInstalacaoEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(TipoInstalacaoEnum s : TipoInstalacaoEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de enum inválido: "+numero);
	}
	
	public static TipoInstalacaoEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(TipoInstalacaoEnum s : TipoInstalacaoEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}
