package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Orcamentoelematcotado;
import com.stellato.repository.OrcamentoelematcotadoRepository;

@Service
public class OrcamentoelematcotadoService {

	@Autowired
	private OrcamentoelematcotadoRepository orcamentoelematcotadoRepository;

	public Orcamentoelematcotado salvar(Orcamentoelematcotado orcamentoelematcotado) {
		return orcamentoelematcotadoRepository.save(orcamentoelematcotado);
	}

	public Orcamentoelematcotado buscarPeloCodigo(Long codigo) {
		Orcamentoelematcotado orcamentoelematcotadoSalva = orcamentoelematcotadoRepository.findById(codigo).get();
		if (orcamentoelematcotadoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return orcamentoelematcotadoSalva;
	}

	public Orcamentoelematcotado atualizar(Long codigo, Orcamentoelematcotado orcamentoelematcotado) {
		Orcamentoelematcotado orcamentoelematcotadoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(orcamentoelematcotado, orcamentoelematcotadoSave, "orcamentoelematcotadoid");
		return orcamentoelematcotadoRepository.save(orcamentoelematcotadoSave);
	}

	public Page<Orcamentoelematcotado> pesquisar(Pageable pageable){
		return orcamentoelematcotadoRepository.findAll(pageable);
	}

	public List<Orcamentoelematcotado> listarTodos() {
		return orcamentoelematcotadoRepository.findAll();
	}

	public void remover(Long codigo) {
		orcamentoelematcotadoRepository.deleteById(codigo);
	}

}