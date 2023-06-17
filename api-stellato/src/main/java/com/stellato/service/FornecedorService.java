package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.Fornecedor;
import com.stellato.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	


	public Fornecedor salvar(Fornecedor fornecedor) {
		fornecedor.ativar();
		return fornecedorRepository.save(fornecedor);
	}

	public Fornecedor buscarPeloCodigo(Long codigo) {
		Fornecedor fornecedorSalva = fornecedorRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		return fornecedorSalva;
	}

	public Fornecedor atualizar(Long codigo, Fornecedor fornecedor) {
		Fornecedor fornecedorSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(fornecedor, fornecedorSave, "id","status");
		return fornecedorRepository.save(fornecedorSave);
	}

	public Page<Fornecedor> pesquisar(Pageable pageable){
		return fornecedorRepository.findAll(pageable);
	}

	public List<Fornecedor> listarTodos() {
		return fornecedorRepository.findAll();
	}

	public void remover(Long codigo) {
		Fornecedor fornecedor = buscarPeloCodigo(codigo);
		fornecedor.inativar();
		fornecedorRepository.save(fornecedor);
	}

	public List<Fornecedor> listarTodosAtivos() {
		return fornecedorRepository.listarTodosAtivos();
	}
	
	public Page<Fornecedor> listarTodosAtivos(Pageable pageable) {
		return fornecedorRepository.listarTodosAtivos(pageable);
	}

	public Page<Fornecedor> buscaGenerica(String pesquisa, Pageable pageable) {
		return fornecedorRepository.buscaGenerica(pesquisa.toUpperCase(),pageable);
	}

}