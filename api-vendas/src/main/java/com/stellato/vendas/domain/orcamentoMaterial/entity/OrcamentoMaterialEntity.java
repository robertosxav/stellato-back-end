package com.stellato.vendas.domain.orcamentoMaterial.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;
import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.domain.shared.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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

	public OrcamentoMaterialEntity( Long id, MaterialCotadoEntity materialCotado,OrcamentoEletricoEntity orcamentoEletrico, Long quantidade, 
			BigDecimal valor,String codigo, Integer statusNumero, LocalDate criadoEm, Long criadoPor,LocalDate alteradoEm, Long alteradoPor) {
		super(codigo, statusNumero, criadoEm, criadoPor, alteradoEm, alteradoPor);
		this.id = id;
		this.materialCotado = materialCotado;
		this.orcamentoEletrico = orcamentoEletrico;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	
}
