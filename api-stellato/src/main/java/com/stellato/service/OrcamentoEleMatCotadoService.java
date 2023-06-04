package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.OrcamentoEleMatCotado;
import com.stellato.repository.OrcamentoEleMatCotadoRepository;

@Service
public class OrcamentoEleMatCotadoService {

	@Autowired
	private OrcamentoEleMatCotadoRepository orcamentoelematcotadoRepository;

	public OrcamentoEleMatCotado salvar(OrcamentoEleMatCotado orcamentoelematcotado) {
		return orcamentoelematcotadoRepository.save(orcamentoelematcotado);
	}

	public OrcamentoEleMatCotado buscarPeloCodigo(Long codigo) {
		OrcamentoEleMatCotado orcamentoelematcotadoSalva = orcamentoelematcotadoRepository.findById(codigo).get();
		if (orcamentoelematcotadoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return orcamentoelematcotadoSalva;
	}

	public OrcamentoEleMatCotado atualizar(Long codigo, OrcamentoEleMatCotado orcamentoelematcotado) {
		OrcamentoEleMatCotado orcamentoelematcotadoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(orcamentoelematcotado, orcamentoelematcotadoSave, "orcamentoelematcotadoid");
		return orcamentoelematcotadoRepository.save(orcamentoelematcotadoSave);
	}

	public Page<OrcamentoEleMatCotado> pesquisar(Pageable pageable){
		return orcamentoelematcotadoRepository.findAll(pageable);
	}

	public List<OrcamentoEleMatCotado> listarTodos() {
		return orcamentoelematcotadoRepository.findAll();
	}

	public void remover(Long codigo) {
		orcamentoelematcotadoRepository.deleteById(codigo);
	}

}