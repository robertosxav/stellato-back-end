package com.stellato.vendas.domain.orcamentoMaterial.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;
import com.stellato.vendas.domain.materialCotado.factory.MaterialCotadoEntityFactory;
import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.domain.orcamento.factory.OrcamentoEntityFactory;
import com.stellato.vendas.domain.orcamentoMaterial.entity.OrcamentoMaterialEntity;
import com.stellato.vendas.infrastructure.orcamentoMaterial.OrcamentoMaterialModel;

@Component
public class OrcamentoMaterialEntityFactory {
	
	@Autowired
	MaterialCotadoEntityFactory materialCotadoFactory;
	
	@Autowired
	OrcamentoEntityFactory orcamentoEntityFactory;
	
	public OrcamentoMaterialEntity create (OrcamentoMaterialModel orcamentoMaterialModel) {
		
		MaterialCotadoEntity materialCotadoEntity = materialCotadoFactory.create(orcamentoMaterialModel.getMaterialCotado());
		OrcamentoEletricoEntity orcamentoEletricoEntity = orcamentoEntityFactory.create(orcamentoMaterialModel.getOrcamentoEletrico());
		
		OrcamentoMaterialEntity orcamentoMaterialEntity = new OrcamentoMaterialEntity(orcamentoMaterialModel.getId(), materialCotadoEntity,orcamentoEletricoEntity, orcamentoMaterialModel.getQuantidade(), orcamentoMaterialModel.getValor(),
				orcamentoMaterialModel.getCodigo(), orcamentoMaterialModel.getStatus(),orcamentoMaterialModel.getCriadoEm(), orcamentoMaterialModel.getCriadoPor(), orcamentoMaterialModel.getAlteradoEm(),
				orcamentoMaterialModel.getAlteradoPor()) ;
		return orcamentoMaterialEntity;
	}
	
}
