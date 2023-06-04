package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.EtapasFunil;
import com.stellato.repository.EtapasFunilRepository;

@Service
public class EtapasFunilService {

	@Autowired
	private EtapasFunilRepository etapasfunilRepository;

	public EtapasFunil salvar(EtapasFunil etapasfunil) {
		return etapasfunilRepository.save(etapasfunil);
	}

	public EtapasFunil buscarPeloCodigo(Long codigo) {
		EtapasFunil etapasfunilSalva = etapasfunilRepository.findById(codigo).get();
		if (etapasfunilSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return etapasfunilSalva;
	}

	public EtapasFunil atualizar(Long codigo, EtapasFunil etapasfunil) {
		EtapasFunil etapasfunilSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(etapasfunil, etapasfunilSave, "etapasfunilid");
		return etapasfunilRepository.save(etapasfunilSave);
	}

	public Page<EtapasFunil> pesquisar(Pageable pageable){
		return etapasfunilRepository.findAll(pageable);
	}

	public List<EtapasFunil> listarTodos() {
		return etapasfunilRepository.findAll();
	}

	public void remover(Long codigo) {
		etapasfunilRepository.deleteById(codigo);
	}

}