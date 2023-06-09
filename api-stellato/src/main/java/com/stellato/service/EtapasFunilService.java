package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.EtapasFunil;
import com.stellato.model.FunilVendas;
import com.stellato.repository.EtapasFunilRepository;

@Service
public class EtapasFunilService {

	@Autowired
	private EtapasFunilRepository etapasfunilRepository;

	@Autowired
	private FunilVendasService funilVendasService;
	
	public EtapasFunil salvar(EtapasFunil etapasfunil) {
		validar(etapasfunil);
		etapasfunil.ativar();
		return etapasfunilRepository.save(etapasfunil);
	}

	private void validar(EtapasFunil etapasfunil) {
		FunilVendas funilVendas = funilVendasService.buscarPeloCodigo(etapasfunil.getFunilVendas().getId());
		etapasfunil.setFunilVendas(funilVendas);
	}

	public EtapasFunil buscarPeloCodigo(Long codigo) {
		EtapasFunil etapasfunilSalva = etapasfunilRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		return etapasfunilSalva;
	}

	public EtapasFunil atualizar(Long codigo, EtapasFunil etapasfunil) {
		EtapasFunil etapasfunilSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(etapasfunil, etapasfunilSave, "id","status");
		return etapasfunilRepository.save(etapasfunilSave);
	}

	public Page<EtapasFunil> pesquisar(Pageable pageable){
		return etapasfunilRepository.findAll(pageable);
	}

	public List<EtapasFunil> listarTodos() {
		return etapasfunilRepository.findAll();
	}

	public void remover(Long codigo) {
		EtapasFunil etapasFunil = buscarPeloCodigo(codigo);
		etapasFunil.inativar();
		etapasfunilRepository.save(etapasFunil);
	}

	public Page<EtapasFunil> listarTodosAtivos(Pageable pageable) {
		return etapasfunilRepository.listarTodosAtivos(pageable);
	}

	public List<EtapasFunil> listarTodosAtivos() {
		return etapasfunilRepository.listarTodosAtivos();
	}

	public Page<EtapasFunil> buscaGenerica(String pesquisa, Pageable pageable) {
		return etapasfunilRepository.buscaGenerica(pesquisa.toUpperCase(),pageable);
	}
	
	public List<EtapasFunil> buscarPeloFunil(Long idFunilVendas){
		return etapasfunilRepository.buscarPeloFunil(idFunilVendas);
	}
}