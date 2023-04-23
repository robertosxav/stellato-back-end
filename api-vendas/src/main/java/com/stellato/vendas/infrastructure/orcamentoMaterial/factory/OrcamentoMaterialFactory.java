package com.stellato.vendas.infrastructure.orcamentoMaterial.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stellato.vendas.domain.orcamentoMaterial.entity.OrcamentoMaterialEntity;
import com.stellato.vendas.infrastructure.materialCotado.factory.MaterialCotadoFactory;
import com.stellato.vendas.infrastructure.materialCotado.model.MaterialCotadoModel;
import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;
import com.stellato.vendas.infrastructure.orcamento.factory.OrcamentoFactory;
import com.stellato.vendas.infrastructure.orcamentoMaterial.OrcamentoMaterialModel;

@Component
public class OrcamentoMaterialFactory {
	
	@Autowired
	MaterialCotadoFactory materialCotadoFactory;
	
	@Autowired
	OrcamentoFactory orcamentoEntityFactory;
	
	public OrcamentoMaterialModel create (OrcamentoMaterialEntity orcamentoMaterialEntity) {
		
		MaterialCotadoModel materialCotado = materialCotadoFactory.create(orcamentoMaterialEntity.getMaterialCotado());
		OrcamentoEletricoModel orcamentoEletrico = orcamentoEntityFactory.create(orcamentoMaterialEntity.getOrcamentoEletrico());
		
		OrcamentoMaterialModel orcamentoMaterialModel = new OrcamentoMaterialModel(orcamentoMaterialEntity.getId(), materialCotado,orcamentoEletrico, orcamentoMaterialEntity.getQuantidade(), orcamentoMaterialEntity.getValor(),
				orcamentoMaterialEntity.getCodigo(), orcamentoMaterialEntity.getStatus().getNumero(),orcamentoMaterialEntity.getCriadoEm(), orcamentoMaterialEntity.getCriadoPor(), orcamentoMaterialEntity.getAlteradoEm(),
				orcamentoMaterialEntity.getAlteradoPor()) ;
		return orcamentoMaterialModel;
	}
	
}
