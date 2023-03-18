package com.stellato.vendas.infrastructure.lead.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stellato.vendas.domain.lead.entity.LeadEntity;
import com.stellato.vendas.domain.shared.enumerated.StatusEnum;
import com.stellato.vendas.domain.shared.repository.RepositoryInterface;
import com.stellato.vendas.exceptions.StellatoException;
import com.stellato.vendas.infrastructure.lead.LeadModel;
import com.stellato.vendas.infrastructure.lead.repository.LeadRepository;

import jakarta.transaction.Transactional;

@Service
public class LeadService implements RepositoryInterface<LeadEntity>{

	@Autowired
	private LeadRepository leadRepository;
	
	@Override
	@Transactional
	public LeadEntity create(LeadEntity leadEntityFront){
	
		if (leadEntityFront.validar()) {
			leadEntityFront.Ativar();
			LeadModel leadModel = new LeadModel(leadEntityFront.getNome(), leadEntityFront.getEmail(), leadEntityFront.getTelefone(), 
					leadEntityFront.getConsumo(), leadEntityFront.getCidade(), leadEntityFront.getTipoTelha().getNumero(), leadEntityFront.getOrigem().getNumero(), leadEntityFront.getStatus().getNumero());
			leadRepository.save(leadModel);
			
			leadEntityFront.SetId(leadModel.getId());
		
			return leadEntityFront;
		}
		return null;
	}

	@Override
	@Transactional
	public LeadEntity update(BigDecimal id, LeadEntity leadEntityFront){
			LeadEntity leadEntityBanco = findById(id);
			
			LeadModel leadModel = new LeadModel(leadEntityFront.getId(),leadEntityFront.getNome(), leadEntityFront.getEmail(), leadEntityFront.getTelefone(), 
					leadEntityFront.getConsumo(), leadEntityFront.getCidade(), leadEntityFront.getTipoTelha().getNumero(), leadEntityFront.getOrigem().getNumero(), 
					leadEntityBanco.getStatus().getNumero());
			leadRepository.save(leadModel);
			
			leadEntityFront.SetId(id);
			leadEntityFront.setStatus(StatusEnum.ATIVO);
			
			return leadEntityFront;

	}

	@Override
	public LeadEntity findById(BigDecimal id) {
		Optional<LeadEntity> leadEntitySave= leadRepository.buscarPorId(id);
		
		 if (!leadEntitySave.isPresent()) {
			 throw new StellatoException("Não foi encontrado nenhum lead com o código: " + id.toBigInteger());
		 }
		 
		return leadEntitySave.get();

	}

	@Override
	public List<LeadEntity> findAll(){
		
		List<LeadEntity> listaLeadEntity =  leadRepository.listarTodos();
		
		if (listaLeadEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead cadastrado"); 
		}
	
		return listaLeadEntity;
	}
	
	public List<LeadEntity> findAllActives(){
		
		List<LeadEntity> listaLeadEntity =  leadRepository.listarAtivos();
		
		if (listaLeadEntity.isEmpty()) {
			throw new StellatoException("Não foi encontrado nenhum lead ativo"); 
		}
	
		return listaLeadEntity;
	}

	
	public void deleteLead(BigDecimal id) {
		LeadEntity leadEntityBanco = findById(id);
		
		leadEntityBanco.Inativar();
		
		LeadModel leadModel = new LeadModel(leadEntityBanco.getId(),leadEntityBanco.getNome(), leadEntityBanco.getEmail(), leadEntityBanco.getTelefone(), 
				leadEntityBanco.getConsumo(), leadEntityBanco.getCidade(), leadEntityBanco.getTipoTelha().getNumero(), leadEntityBanco.getOrigem().getNumero(), leadEntityBanco.getStatus().getNumero());
		leadRepository.save(leadModel);
		
	}

}
