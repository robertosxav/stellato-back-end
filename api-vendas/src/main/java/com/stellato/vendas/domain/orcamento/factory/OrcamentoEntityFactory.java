package com.stellato.vendas.domain.orcamento.factory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.domain.lead.factory.LeadEntityFactory;
import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;
import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.domain.orcamentoMaterial.entity.OrcamentoMaterialEntity;
import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;
import com.stellato.vendas.infrastructure.orcamentoMaterial.OrcamentoMaterialModel;

@Component
public class OrcamentoEntityFactory {
	
	@Autowired
	private LeadEntityFactory factory; 
	
	public OrcamentoEletricoEntity create(OrcamentoEletricoModel orcamentoEletricoModel) {
		
		LeadEntity leadEntity = factory.create(orcamentoEletricoModel.getLead()); 
		
		OrcamentoEletricoEntity orcamentoEletricoEntity = new OrcamentoEletricoEntity(orcamentoEletricoModel.getId(),orcamentoEletricoModel.getCodigo(),orcamentoEletricoModel.getTitulo(),orcamentoEletricoModel.getObservacao(),
				orcamentoEletricoModel.getObservacaoInterna(),orcamentoEletricoModel.getValidadeProposta(),orcamentoEletricoModel.getPrazoEntrega(),orcamentoEletricoModel.getDistancia(),
				orcamentoEletricoModel.getPotenciaModulo(),orcamentoEletricoModel.getPercentualPerda(),orcamentoEletricoModel.getDetalheProposta(),orcamentoEletricoModel.getModalidadeTarifaria(),
				orcamentoEletricoModel.getTipoPadrao(),orcamentoEletricoModel.getUnidadeConsumidora(),orcamentoEletricoModel.getConsumoMedio(),orcamentoEletricoModel.getPrecoKwh(), 
				orcamentoEletricoModel.getTipoInstalacao(),orcamentoEletricoModel.getTipoEstrutura(),leadEntity,orcamentoEletricoModel.getStatus(), 
				orcamentoEletricoModel.getCriadoEm(), orcamentoEletricoModel.getCriadoPor(),orcamentoEletricoModel.getAlteradoEm(), orcamentoEletricoModel.getAlteradoPor());

		for(OrcamentoMaterialModel orcamentoMaterialModel :orcamentoEletricoModel.getListaMateriais()) {
			MaterialCotadoEntity materialCotadoEntity = new MaterialCotadoEntity(orcamentoMaterialModel.getMaterialCotado().getId(), orcamentoMaterialModel.getMaterialCotado().getCodigo(),
					orcamentoMaterialModel.getMaterialCotado().getObservacao(), orcamentoMaterialModel.getMaterialCotado().getValor(), orcamentoMaterialModel.getMaterialCotado().getIdFornecedor(),
					orcamentoMaterialModel.getMaterialCotado().getRazaoSocial(), orcamentoMaterialModel.getMaterialCotado().getCnpj(), orcamentoMaterialModel.getMaterialCotado().getIdMaterial(),
					orcamentoMaterialModel.getMaterialCotado().getDescricaoMaterial(), orcamentoMaterialModel.getMaterialCotado().getCriadoEm(), orcamentoMaterialModel.getMaterialCotado().getCriadoPor(),
					orcamentoMaterialModel.getMaterialCotado().getAlteradoEm(), orcamentoMaterialModel.getMaterialCotado().getAlteradoPor());
			
			OrcamentoMaterialEntity orcamentoMaterialEntity = new OrcamentoMaterialEntity(orcamentoMaterialModel.getCodigo(), orcamentoEletricoModel.getStatus(), 
					orcamentoEletricoModel.getCriadoEm(), orcamentoEletricoModel.getCriadoPor(), orcamentoEletricoModel.getAlteradoEm(), orcamentoEletricoModel.getAlteradoPor(),
					orcamentoEletricoModel.getId(), materialCotadoEntity, null, orcamentoMaterialModel.getQuantidade(), orcamentoMaterialModel.getValor());
			orcamentoEletricoEntity.addMaterial(orcamentoMaterialEntity);
		}
		return orcamentoEletricoEntity;
	}
}
