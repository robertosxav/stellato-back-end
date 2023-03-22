package com.stellato.vendas.infrastructure.lead.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.domain.lead.factory.LeadEntityFactory;
import com.stellato.vendas.domain.shared.repository.RepositoryInterface;
import com.stellato.vendas.exceptions.StellatoException;
import com.stellato.vendas.infrastructure.lead.LeadModel;
import com.stellato.vendas.infrastructure.lead.factory.LeadFactory;
import com.stellato.vendas.infrastructure.lead.repository.LeadRepository;

import jakarta.transaction.Transactional;

@Service
public class LeadService implements RepositoryInterface<LeadEntity>{

	@Autowired
	private LeadRepository leadRepository;
	
	@Autowired
	private LeadFactory factory; 
	
	@Autowired
	private LeadEntityFactory entityFactory;
	
	@Override
	@Transactional
	public LeadEntity create(LeadEntity leadEntityFront){
	
		if (leadEntityFront.validar()) {
			leadEntityFront.Ativar();
			LeadModel leadModel = factory.create(leadEntityFront);
			
			leadRepository.save(leadModel);
			
			leadEntityFront.SetId(leadModel.getId());
		
			return leadEntityFront;
		}
		return null;
	}

	@Override
	@Transactional
	public LeadEntity update(Long id, LeadEntity leadEntityFront){
			
			leadEntityFront.Alterar(null);
			
			Optional<LeadModel> leadModelBanco = leadRepository.buscarPorId(id);
			
			leadModelBanco.get().setNome(leadEntityFront.getNome());
			leadModelBanco.get().setTelefone(leadEntityFront.getNome());
			leadModelBanco.get().setwhatsapp(leadEntityFront.getWhatsApp());
			leadModelBanco.get().setCidade(leadEntityFront.getCidade());
			leadModelBanco.get().setOrigem(leadEntityFront.getOrigem());
			leadModelBanco.get().setTipoLead(leadEntityFront.getTipoLead());
			leadModelBanco.get().setidPessoa(leadEntityFront.getidPessoa());
			leadModelBanco.get().setStatus(leadEntityFront.getStatus().getNumero());
			leadModelBanco.get().setCriadoEm(leadEntityFront.getCriadoEm());
			leadModelBanco.get().setCriadoPor(leadEntityFront.getCriadoPor());
			leadModelBanco.get().setAlteradoEm(leadEntityFront.getAlteradoEm());
			leadModelBanco.get().setAlteradoPor(leadEntityFront.getAlteradoPor());
			leadRepository.save(leadModelBanco.get());
			
		return leadEntityFront;


	}

	@Override
	public LeadEntity findById(Long id) {
		Optional<LeadModel> leadModelSave = leadRepository.buscarPorId(id);
		
		 if (!leadModelSave.isPresent()) {
			 throw new StellatoException("Não foi encontrado nenhum lead com o código: " + id);
		 }
		LeadEntity leadEntity	=	entityFactory.create(leadModelSave.get());
		return leadEntity;

	}

	@Override
	public List<LeadEntity> findAll(){
		
		List<LeadModel> listaLeaModel = leadRepository.listarTodos();
		
		if (listaLeaModel.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead cadastrado"); 
		}
		
		return listaLeaModel.stream().map(e->(entityFactory.create(e))).collect(Collectors.toList());
		
	}
	
	public List<LeadEntity> findAllActives(){
		
		List<LeadModel> listaLeadModel =  leadRepository.listarAtivos();
		
		if (listaLeadModel.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead ativo"); 
		}
	
		return listaLeadModel.stream().map(e->(entityFactory.create(e))).collect(Collectors.toList());
	}

	
	public void deleteLead(Long id) {
		LeadEntity leadEntityBanco = findById(id);
		
		leadEntityBanco.Inativar();

		
		LeadModel leadModel	= factory.create(leadEntityBanco);
		leadRepository.save(leadModel);
		
	}

}
