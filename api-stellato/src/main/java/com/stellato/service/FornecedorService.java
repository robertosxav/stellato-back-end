package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.model.Fornecedor;
import com.stellato.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public Fornecedor salvar(Fornecedor fornecedor) {
		return fornecedorRepository.save(fornecedor);
	}

	public Fornecedor buscarPeloCodigo(Long codigo) {
		Fornecedor fornecedorSalva = fornecedorRepository.findById(codigo).get();
		if (fornecedorSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return fornecedorSalva;
	}

	public Fornecedor atualizar(Long codigo, Fornecedor fornecedor) {
		Fornecedor fornecedorSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(fornecedor, fornecedorSave, "fornecedorid");
		return fornecedorRepository.save(fornecedorSave);
	}

	public Page<Fornecedor> pesquisar(Pageable pageable){
		return fornecedorRepository.findAll(pageable);
	}

	public List<Fornecedor> listarTodos() {
		return fornecedorRepository.findAll();
	}

	public void remover(Long codigo) {
		fornecedorRepository.deleteById(codigo);
	}

}