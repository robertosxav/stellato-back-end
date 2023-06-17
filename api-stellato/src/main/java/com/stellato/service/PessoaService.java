package com.stellato.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.Fornecedor;
import com.stellato.model.Pessoa;
import com.stellato.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private FornecedorService fornecedorService;

	@Transactional
	public Pessoa salvar(Pessoa pessoa) {
		pessoa.ativar();
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		pessoa.setId(pessoaSalva.getId());
		gerarRegistroFornecedor(pessoa);
		return pessoaSalva;
	}
	
	@Transactional
	private void gerarRegistroFornecedor(Pessoa pessoa) {
		if (pessoa.getIsFornecedor()) {
			Fornecedor fornecedor 	=	new Fornecedor(pessoa.getId(),pessoa.getNomeFantasia());
			fornecedorService.salvar(fornecedor);
		}
		
	}
	
	public Pessoa buscarPeloCodigo(Long codigo) {
		Pessoa pessoaSalva = pessoaRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		return pessoaSalva;
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa pessoaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(pessoa, pessoaSave, "id","status");
		return pessoaRepository.save(pessoaSave);
	}

	public Page<Pessoa> pesquisar(Pageable pageable){
		return pessoaRepository.findAll(pageable);
	}

	public List<Pessoa> listarTodos() {
		return pessoaRepository.findAll();
	}

	public void remover(Long codigo) {
		Pessoa pessoa =  buscarPeloCodigo(codigo);
		pessoa.inativar();
		pessoaRepository.save(pessoa);
	}

	public Page<Pessoa> listarTodosAtivos(Pageable pageable) {
		return pessoaRepository.listarTodosAtivos(pageable);
	}

	public List<Pessoa> listarTodosAtivos() {
		return pessoaRepository.listarTodosAtivos();
	}

	public Page<Pessoa> buscaGenerica(String pesquisa, Pageable pageable) {
		return pessoaRepository.buscaGenerica(pesquisa,pageable);
	}

}