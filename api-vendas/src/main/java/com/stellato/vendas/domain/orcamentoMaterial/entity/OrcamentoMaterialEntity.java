package com.stellato.vendas.domain.orcamentoMaterial.entity;

import java.math.BigDecimal;

import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;
import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.domain.shared.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrcamentoMaterialEntity extends BaseEntity {
	
	private Long id;

	private MaterialCotadoEntity materialCotado;
	
	private OrcamentoEletricoEntity orcamentoEletrico;
	
	private Long quantidade;
	
	private BigDecimal valor;

	@Override
	public void SetId(Long id) {
		this.id = id;
	}

	@Override
	public Boolean validar() {
		return true;
	}
}
