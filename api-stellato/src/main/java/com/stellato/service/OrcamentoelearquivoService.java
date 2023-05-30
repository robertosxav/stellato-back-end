package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Orcamentoelearquivo;
import com.stellato.repository.OrcamentoelearquivoRepository;

@Service
public class OrcamentoelearquivoService {

	@Autowired
	private OrcamentoelearquivoRepository orcamentoelearquivoRepository;

	public Orcamentoelearquivo salvar(Orcamentoelearquivo orcamentoelearquivo) {
		return orcamentoelearquivoRepository.save(orcamentoelearquivo);
	}

	public Orcamentoelearquivo buscarPeloCodigo(Long codigo) {
		Orcamentoelearquivo orcamentoelearquivoSalva = orcamentoelearquivoRepository.findById(codigo).get();
		if (orcamentoelearquivoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return orcamentoelearquivoSalva;
	}

	public Orcamentoelearquivo atualizar(Long codigo, Orcamentoelearquivo orcamentoelearquivo) {
		Orcamentoelearquivo orcamentoelearquivoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(orcamentoelearquivo, orcamentoelearquivoSave, "orcamentoelearquivoid");
		return orcamentoelearquivoRepository.save(orcamentoelearquivoSave);
	}

	public Page<Orcamentoelearquivo> pesquisar(Pageable pageable){
		return orcamentoelearquivoRepository.findAll(pageable);
	}

	public List<Orcamentoelearquivo> listarTodos() {
		return orcamentoelearquivoRepository.findAll();
	}

	public void remover(Long codigo) {
		orcamentoelearquivoRepository.deleteById(codigo);
	}

}