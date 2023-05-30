package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Orcamentoeletrico;
import com.stellato.repository.OrcamentoeletricoRepository;

@Service
public class OrcamentoeletricoService {

	@Autowired
	private OrcamentoeletricoRepository orcamentoeletricoRepository;

	public Orcamentoeletrico salvar(Orcamentoeletrico orcamentoeletrico) {
		return orcamentoeletricoRepository.save(orcamentoeletrico);
	}

	public Orcamentoeletrico buscarPeloCodigo(Long codigo) {
		Orcamentoeletrico orcamentoeletricoSalva = orcamentoeletricoRepository.findById(codigo).get();
		if (orcamentoeletricoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return orcamentoeletricoSalva;
	}

	public Orcamentoeletrico atualizar(Long codigo, Orcamentoeletrico orcamentoeletrico) {
		Orcamentoeletrico orcamentoeletricoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(orcamentoeletrico, orcamentoeletricoSave, "orcamentoeletricoid");
		return orcamentoeletricoRepository.save(orcamentoeletricoSave);
	}

	public Page<Orcamentoeletrico> pesquisar(Pageable pageable){
		return orcamentoeletricoRepository.findAll(pageable);
	}

	public List<Orcamentoeletrico> listarTodos() {
		return orcamentoeletricoRepository.findAll();
	}

	public void remover(Long codigo) {
		orcamentoeletricoRepository.deleteById(codigo);
	}

}