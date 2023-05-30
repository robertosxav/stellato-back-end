package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Arquivo;
import com.stellato.repository.ArquivoRepository;

@Service
public class ArquivoService {

	@Autowired
	private ArquivoRepository arquivoRepository;

	public Arquivo salvar(Arquivo arquivo) {
		return arquivoRepository.save(arquivo);
	}

	public Arquivo buscarPeloCodigo(Long codigo) {
		Arquivo arquivoSalva = arquivoRepository.findById(codigo).get();
		if (arquivoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return arquivoSalva;
	}

	public Arquivo atualizar(Long codigo, Arquivo arquivo) {
		Arquivo arquivoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(arquivo, arquivoSave, "arquivoid");
		return arquivoRepository.save(arquivoSave);
	}

	public Page<Arquivo> pesquisar(Pageable pageable){
		return arquivoRepository.findAll(pageable);
	}

	public List<Arquivo> listarTodos() {
		return arquivoRepository.findAll();
	}

	public void remover(Long codigo) {
		arquivoRepository.deleteById(codigo);
	}

}