package com.stellato.vendas.infrastructure.orcamento.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.domain.orcamento.factory.OrcamentoEntityFactory;
import com.stellato.vendas.domain.shared.repository.RepositoryInterface;
import com.stellato.vendas.exceptions.StellatoException;
import com.stellato.vendas.infrastructure.lead.LeadModel;
import com.stellato.vendas.infrastructure.lead.service.LeadService;
import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;
import com.stellato.vendas.infrastructure.orcamento.factory.OrcamentoFactory;
import com.stellato.vendas.infrastructure.orcamento.repository.OrcamentoEletricoRepository;


@Service
public class OrcamentoEletricoService implements RepositoryInterface<OrcamentoEletricoEntity>{

	@Autowired
	private OrcamentoEletricoRepository orcamentoEletricoRepository;
	
	@Autowired
	private OrcamentoFactory factory; 
	
	@Autowired
	private OrcamentoEntityFactory entityFactory;
	
	@Autowired
	private LeadService leadService;
	
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
		return null;

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

}
