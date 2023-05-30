package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Etapasfunil;
import com.stellato.repository.EtapasfunilRepository;

@Service
public class EtapasfunilService {

	@Autowired
	private EtapasfunilRepository etapasfunilRepository;

	public Etapasfunil salvar(Etapasfunil etapasfunil) {
		return etapasfunilRepository.save(etapasfunil);
	}

	public Etapasfunil buscarPeloCodigo(Long codigo) {
		Etapasfunil etapasfunilSalva = etapasfunilRepository.findById(codigo).get();
		if (etapasfunilSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return etapasfunilSalva;
	}

	public Etapasfunil atualizar(Long codigo, Etapasfunil etapasfunil) {
		Etapasfunil etapasfunilSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(etapasfunil, etapasfunilSave, "etapasfunilid");
		return etapasfunilRepository.save(etapasfunilSave);
	}

	public Page<Etapasfunil> pesquisar(Pageable pageable){
		return etapasfunilRepository.findAll(pageable);
	}

	public List<Etapasfunil> listarTodos() {
		return etapasfunilRepository.findAll();
	}

	public void remover(Long codigo) {
		etapasfunilRepository.deleteById(codigo);
	}

}