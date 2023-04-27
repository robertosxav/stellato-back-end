package com.stellato.vendas.infrastructure.orcamento.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.domain.materialCotado.entity.MaterialCotadoEntity;
import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.domain.orcamento.factory.OrcamentoEntityFactory;
import com.stellato.vendas.domain.orcamentoMaterial.entity.OrcamentoMaterialEntity;
import com.stellato.vendas.domain.shared.repository.RepositoryInterface;
import com.stellato.vendas.exceptions.StellatoException;
import com.stellato.vendas.infrastructure.lead.service.LeadService;
import com.stellato.vendas.infrastructure.materialCotado.service.MaterialCotadoService;
import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;
import com.stellato.vendas.infrastructure.orcamento.factory.OrcamentoFactory;
import com.stellato.vendas.infrastructure.orcamento.repository.OrcamentoEletricoRepository;
import com.stellato.vendas.infrastructure.orcamentoMaterial.OrcamentoMaterialModel;
import com.stellato.vendas.infrastructure.orcamentoMaterial.factory.OrcamentoMaterialFactory;
import com.stellato.vendas.infrastructure.orcamentoMaterial.repository.OrcamentoMaterialRepository;


@Service
public class OrcamentoEletricoService implements RepositoryInterface<OrcamentoEletricoEntity>{

	@Autowired
	private OrcamentoEletricoRepository orcamentoEletricoRepository;
	
	@Autowired
	private OrcamentoFactory factory; 
	
	@Autowired
	private OrcamentoEntityFactory entityFactory;
	
	@Autowired
	private OrcamentoMaterialFactory orcMatFactory;
	
	@Autowired
	private LeadService leadService;
	
	@Autowired
	private MaterialCotadoService materialCotadoService;
	
	@Autowired
	private OrcamentoMaterialRepository orcamentoMaterialRepository;
	
	@Override
	@Transactional
	public OrcamentoEletricoEntity create(OrcamentoEletricoEntity orcamentoEletricoEntityFront){
		
 		if (orcamentoEletricoEntityFront.validar()) {
			orcamentoEletricoEntityFront.Ativar();
			
			LeadEntity leadEntity	=	leadService.findById(orcamentoEletricoEntityFront.getLead().getId()); 
			
			orcamentoEletricoEntityFront.setLead(leadEntity);
			
			OrcamentoEletricoModel orcamentoEletricoModel	=	 factory.create(orcamentoEletricoEntityFront);
			
			orcamentoEletricoRepository.save(orcamentoEletricoModel);
			
			orcamentoEletricoEntityFront.SetId(orcamentoEletricoModel.getId());
			
			return orcamentoEletricoEntityFront;

		}
		return null;
	}

	@Override
	@Transactional
	public OrcamentoEletricoEntity update(Long id, OrcamentoEletricoEntity orcamentoEletricoEntityFront){	
		orcamentoEletricoEntityFront.Alterar(null);
		
		OrcamentoEletricoModel orcamentoEletricoModelBanco = orcamentoEletricoRepository
				.findById(id).orElseThrow(()->new StellatoException("Não foi encontrado nenhum orcamento com o código: " + id));
		
		orcamentoEletricoEntityFront.SetId(id);
		
		orcamentoEletricoModelBanco.setId(orcamentoEletricoEntityFront.getId());
		orcamentoEletricoModelBanco.setTitulo(orcamentoEletricoEntityFront.getTitulo());
		orcamentoEletricoModelBanco.setObservacao(orcamentoEletricoEntityFront.getObservacao());
		orcamentoEletricoModelBanco.setObservacaoInterna(orcamentoEletricoEntityFront.getObservacaoInterna());
		orcamentoEletricoModelBanco.setValidadeProposta(orcamentoEletricoEntityFront.getValidadeProposta());
		orcamentoEletricoModelBanco.setPrazoEntrega(orcamentoEletricoEntityFront.getPrazoEntrega());
		orcamentoEletricoModelBanco.setDistancia(orcamentoEletricoEntityFront.getDistancia());
		orcamentoEletricoModelBanco.setPotenciaModulo(orcamentoEletricoEntityFront.getPotenciaModulo());
		orcamentoEletricoModelBanco.setPercentualPerda(orcamentoEletricoEntityFront.getPercentualPerda());
		orcamentoEletricoModelBanco.setDetalheProposta(orcamentoEletricoEntityFront.getDetalheProposta());
		orcamentoEletricoModelBanco.setModalidadeTarifaria(orcamentoEletricoEntityFront.getModalidadeTarifaria().getNumero());
		orcamentoEletricoModelBanco.setTipoPadrao(orcamentoEletricoEntityFront.getTipoPadrao().getNumero());
		orcamentoEletricoModelBanco.setUnidadeConsumidora(orcamentoEletricoEntityFront.getUnidadeConsumidora());
		orcamentoEletricoModelBanco.setConsumoMedio(orcamentoEletricoEntityFront.getConsumoMedio());
		orcamentoEletricoModelBanco.setPrecoKwh(orcamentoEletricoEntityFront.getPrecoKwh());
		orcamentoEletricoModelBanco.setTipoInstalacao(orcamentoEletricoEntityFront.getTipoInstalacao().getNumero());
		orcamentoEletricoModelBanco.setTipoEstrutura(orcamentoEletricoEntityFront.getTipoEstrutura().getNumero());
		
		orcamentoEletricoRepository.save(orcamentoEletricoModelBanco);
		
		return orcamentoEletricoEntityFront;

	}
	
	@Override
	public OrcamentoEletricoEntity findById(Long id) {
		OrcamentoEletricoModel orcamentoEletricoModelSave = orcamentoEletricoRepository
				.findById(id).orElseThrow(()->new StellatoException("Não foi encontrado nenhum orcamento com o código: " + id));
		 
		OrcamentoEletricoEntity orcamentoEletricoEntity	=	entityFactory.create(orcamentoEletricoModelSave);
		return orcamentoEletricoEntity;
	}

	@Override
	public List<OrcamentoEletricoEntity> findAll(){
		
		List<OrcamentoEletricoEntity> listaOrcamentoEletricoEntity = orcamentoEletricoRepository.listarTodos();
		
		if (listaOrcamentoEletricoEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum orçamento cadastrado"); 
		}
		
		return listaOrcamentoEletricoEntity;
	}
	
	@Override
	public List<OrcamentoEletricoEntity> findAllActives(){
		List<OrcamentoEletricoEntity> listaOrcamentoEletricoEntity = orcamentoEletricoRepository.listarAtivos();
		
		if (listaOrcamentoEletricoEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum orçamento ativo"); 
		}
		
		return listaOrcamentoEletricoEntity;
	}
	
	@Override
	public Page<OrcamentoEletricoEntity> findAllActivesPage(Pageable pageable) {
		return orcamentoEletricoRepository.listarAtivos(pageable);
	}
	

	public List<OrcamentoEletricoEntity> findByLead(Long idLead) {
		return orcamentoEletricoRepository.listarPorLead(idLead);
	}
	
	public Page<OrcamentoEletricoEntity> findByLead(Long idLead, Pageable pageable) {
		return orcamentoEletricoRepository.listarPorLead(idLead,pageable);
	}
	
	public void deleteOrcamentoEletrico(Long id) {
		OrcamentoEletricoEntity orcamentoEletricoEntityBanco = findById(id);
		orcamentoEletricoEntityBanco.Inativar();	
		OrcamentoEletricoModel orcamentoEletricoModel	= factory.create(orcamentoEletricoEntityBanco);
		orcamentoEletricoRepository.save(orcamentoEletricoModel);
	}
	

	public List<OrcamentoEletricoModel> teste(){
		
		List<OrcamentoEletricoModel> listaOrcamentoEletricoModel = orcamentoEletricoRepository.teste();
		
		if (listaOrcamentoEletricoModel.isEmpty()) {
			throw new StellatoException("erro teste"); 
		}
		
		return listaOrcamentoEletricoModel;
	}
	
	public void addListaMateriaisOrcamento(List<OrcamentoMaterialEntity> listaOrcamentoMaterial) {
		for(OrcamentoMaterialEntity orcamentoMaterialEntity : listaOrcamentoMaterial) {
			
			validarDados(orcamentoMaterialEntity);
			orcamentoMaterialEntity.gerarUUID();
			orcamentoMaterialEntity.Ativar();
			
			OrcamentoMaterialModel orcamentoMaterialModel	= orcMatFactory.create(orcamentoMaterialEntity);
		    orcamentoMaterialRepository.save(orcamentoMaterialModel);
		}
	}

	private void validarDados(OrcamentoMaterialEntity orcamentoMaterialEntity) {
		
		OrcamentoEletricoEntity orcamentoEletricoEntity = findById(orcamentoMaterialEntity.getOrcamentoEletrico().getId());
		orcamentoMaterialEntity.setOrcamentoEletrico(orcamentoEletricoEntity);
		
		MaterialCotadoEntity materialCotadoEntity = materialCotadoService.findById(orcamentoMaterialEntity.getMaterialCotado().getId());
		orcamentoMaterialEntity.setMaterialCotado(materialCotadoEntity);
	}
}
