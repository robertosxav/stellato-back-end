package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.OrcamentoEletrico;
import com.stellato.repository.OrcamentoEletricoRepository;

@Service
public class OrcamentoEletricoService {

	@Autowired
	private OrcamentoEletricoRepository orcamentoeletricoRepository;

	public OrcamentoEletrico salvar(OrcamentoEletrico orcamentoeletrico) {
		return orcamentoeletricoRepository.save(orcamentoeletrico);
	}

	public OrcamentoEletrico buscarPeloCodigo(Long codigo) {
		OrcamentoEletrico orcamentoeletricoSalva = orcamentoeletricoRepository.findById(codigo).get();
		if (orcamentoeletricoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return orcamentoeletricoSalva;
	}

	public OrcamentoEletrico atualizar(Long codigo, OrcamentoEletrico orcamentoeletrico) {
		OrcamentoEletrico orcamentoeletricoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(orcamentoeletrico, orcamentoeletricoSave, "orcamentoeletricoid");
		return orcamentoeletricoRepository.save(orcamentoeletricoSave);
	}

	public Page<OrcamentoEletrico> pesquisar(Pageable pageable){
		return orcamentoeletricoRepository.findAll(pageable);
	}

	public List<OrcamentoEletrico> listarTodos() {
		return orcamentoeletricoRepository.findAll();
	}

	public void remover(Long codigo) {
		orcamentoeletricoRepository.deleteById(codigo);
	}

}