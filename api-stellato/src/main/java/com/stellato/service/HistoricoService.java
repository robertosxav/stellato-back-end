package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Historico;
import com.stellato.repository.HistoricoRepository;

@Service
public class HistoricoService {

	@Autowired
	private HistoricoRepository historicoRepository;

	public Historico salvar(Historico historico) {
		return historicoRepository.save(historico);
	}

	public Historico buscarPeloCodigo(Long codigo) {
		Historico historicoSalva = historicoRepository.findById(codigo).get();
		if (historicoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return historicoSalva;
	}

	public Historico atualizar(Long codigo, Historico historico) {
		Historico historicoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(historico, historicoSave, "historicoid");
		return historicoRepository.save(historicoSave);
	}

	public Page<Historico> pesquisar(Pageable pageable){
		return historicoRepository.findAll(pageable);
	}

	public List<Historico> listarTodos() {
		return historicoRepository.findAll();
	}

	public void remover(Long codigo) {
		historicoRepository.deleteById(codigo);
	}

}