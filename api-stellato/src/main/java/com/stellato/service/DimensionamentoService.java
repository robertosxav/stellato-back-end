package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Dimensionamento;
import com.stellato.repository.DimensionamentoRepository;

@Service
public class DimensionamentoService {

	@Autowired
	private DimensionamentoRepository dimensionamentoRepository;

	public Dimensionamento salvar(Dimensionamento dimensionamento) {
		return dimensionamentoRepository.save(dimensionamento);
	}

	public Dimensionamento buscarPeloCodigo(Long codigo) {
		Dimensionamento dimensionamentoSalva = dimensionamentoRepository.findById(codigo).get();
		if (dimensionamentoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return dimensionamentoSalva;
	}

	public Dimensionamento atualizar(Long codigo, Dimensionamento dimensionamento) {
		Dimensionamento dimensionamentoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(dimensionamento, dimensionamentoSave, "dimensionamentoid");
		return dimensionamentoRepository.save(dimensionamentoSave);
	}

	public Page<Dimensionamento> pesquisar(Pageable pageable){
		return dimensionamentoRepository.findAll(pageable);
	}

	public List<Dimensionamento> listarTodos() {
		return dimensionamentoRepository.findAll();
	}

	public void remover(Long codigo) {
		dimensionamentoRepository.deleteById(codigo);
	}

}