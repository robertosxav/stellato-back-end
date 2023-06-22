package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.Lead;
import com.stellato.model.Pessoa;
import com.stellato.repository.LeadRepository;

@Service
public class LeadService {

	@Autowired
	private LeadRepository leadRepository;
	
	@Autowired
	PessoaService pessoaService;

	public Lead salvar(Lead lead) {
		validar(lead);
		lead.ativar();
		return leadRepository.save(lead);
	}

	private void validar(Lead lead) {
		if (lead.getPessoa() != null) {
			Pessoa pessoa = pessoaService.buscarPeloCodigo(lead.getPessoa().getId());
			lead.setPessoa(pessoa);			
		}
	}

	public Lead buscarPeloCodigo(Long codigo) {
		Lead leadSalva = leadRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		return leadSalva;
	}

	public Lead atualizar(Long codigo, Lead lead) {
		Lead leadSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(lead, leadSave, "id","status","criadoEm");
		return leadRepository.save(leadSave);
	}

	public Page<Lead> pesquisar(Pageable pageable){
		return leadRepository.findAll(pageable);
	}

	public List<Lead> listarTodos() {
		return leadRepository.findAll();
	}

	public void remover(Long codigo) {
		Lead leadBanco = buscarPeloCodigo(codigo);
		leadBanco.inativar();
		leadRepository.save(leadBanco);
	}

	public Page<Lead> listarTodosAtivos(Pageable pageable) {
		return leadRepository.listarTodosAtivos(pageable);
	}

	public List<Lead> listarTodosAtivos() {
		return leadRepository.listarTodosAtivos();
	}

	public Page<Lead> buscaGenerica(String pesquisa, Pageable pageable) {
		return leadRepository.buscaGenerica(pesquisa.toUpperCase(),pageable);
	}

}