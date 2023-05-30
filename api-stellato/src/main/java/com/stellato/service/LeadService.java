package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Lead;
import com.stellato.repository.LeadRepository;

@Service
public class LeadService {

	@Autowired
	private LeadRepository leadRepository;

	public Lead salvar(Lead lead) {
		return leadRepository.save(lead);
	}

	public Lead buscarPeloCodigo(Long codigo) {
		Lead leadSalva = leadRepository.findById(codigo).get();
		if (leadSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return leadSalva;
	}

	public Lead atualizar(Long codigo, Lead lead) {
		Lead leadSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(lead, leadSave, "leadid");
		return leadRepository.save(leadSave);
	}

	public Page<Lead> pesquisar(Pageable pageable){
		return leadRepository.findAll(pageable);
	}

	public List<Lead> listarTodos() {
		return leadRepository.findAll();
	}

	public void remover(Long codigo) {
		leadRepository.deleteById(codigo);
	}

}