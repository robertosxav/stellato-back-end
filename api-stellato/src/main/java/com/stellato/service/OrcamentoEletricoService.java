package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
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
		OrcamentoEletrico orcamentoeletricoSalva = orcamentoeletricoRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		return orcamentoeletricoSalva;
	}

	public OrcamentoEletrico atualizar(Long codigo, OrcamentoEletrico orcamentoeletrico) {
		OrcamentoEletrico orcamentoeletricoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(orcamentoeletrico, orcamentoeletricoSave, "id","status");
		return orcamentoeletricoRepository.save(orcamentoeletricoSave);
	}

	public Page<OrcamentoEletrico> pesquisar(Pageable pageable){
		return orcamentoeletricoRepository.findAll(pageable);
	}

	public List<OrcamentoEletrico> listarTodos() {
		return orcamentoeletricoRepository.findAll();
	}

	public void remover(Long codigo) {
		OrcamentoEletrico orcamentoEletrico = buscarPeloCodigo(codigo);
		orcamentoEletrico.inativar();
		orcamentoeletricoRepository.save(orcamentoEletrico);
	}

}