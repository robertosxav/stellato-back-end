package com.stellato.vendas.domain.lead.entity.enumerated;

import com.stellato.vendas.exceptions.StellatoException;

public enum TipoLeadEnum {
	
	PESSOA_FISICA(0,"PESSOA FISICA"),
	PESSOA_JURIDICA(1,"PESSOA JURIDICA");
	
	private Integer numero;
	private String descricao;
	
	TipoLeadEnum(Integer numero, String descricao) {
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
	
	public static TipoLeadEnum toEnum(Integer numero) {
		if (numero == null) {
			return null;
		}
		
		for(TipoLeadEnum s : TipoLeadEnum.values()) {
			if(numero.equals(s.getNumero())){
				return s;
			}
		}
		
		throw new StellatoException("Código de enum inválido: "+numero);
	}
	
	public static TipoLeadEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new StellatoException("Enum inválido: "+descricao);
		}
		
		for(TipoLeadEnum s : TipoLeadEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new StellatoException("Enum inválido: "+descricao);
	}
}
