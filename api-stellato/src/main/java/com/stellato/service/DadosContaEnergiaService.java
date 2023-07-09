package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.DadosContaEnergia;
import com.stellato.model.Distribuidora;
import com.stellato.model.OrcamentoEletrico;
import com.stellato.repository.DadosContaEnergiaRepository;

@Service
public class DadosContaEnergiaService {

	@Autowired
	private DadosContaEnergiaRepository dadosContaEnergiaRepository;

	@Autowired
	private OrcamentoEletricoService orcamentoEletricoService;
	
	private DistribuidoraService distribuidoraService;
	
	public DadosContaEnergia salvar(DadosContaEnergia dadosContaEnergia) {
		validar(dadosContaEnergia);
		dadosContaEnergia.ativar();
		return dadosContaEnergiaRepository.save(dadosContaEnergia);
	}

	private void validar(DadosContaEnergia dadosContaEnergia) {
		OrcamentoEletrico orcamentoEletrico = orcamentoEletricoService
												.buscarPeloCodigo(dadosContaEnergia.getOrcamentoEletrico().getId());
		dadosContaEnergia.setOrcamentoEletrico(orcamentoEletrico);
		
		Distribuidora distribuidora = distribuidoraService
													.buscarPeloCodigo(dadosContaEnergia.getDistribuidora().getId());
		dadosContaEnergia.setDistribuidora(distribuidora);
	}

	public DadosContaEnergia buscarPeloCodigo(Long codigo) {
		DadosContaEnergia dadosContaEnergiaSalva = dadosContaEnergiaRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		return dadosContaEnergiaSalva;
	}

	public DadosContaEnergia atualizar(Long codigo, DadosContaEnergia dadosContaEnergia) {
		DadosContaEnergia dadosContaEnergiaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(dadosContaEnergia, dadosContaEnergiaSave, "id","status");
		return dadosContaEnergiaRepository.save(dadosContaEnergiaSave);
	}

	public Page<DadosContaEnergia> pesquisar(Pageable pageable){
		return dadosContaEnergiaRepository.findAll(pageable);
	}

	public List<DadosContaEnergia> listarTodos() {
		return dadosContaEnergiaRepository.findAll();
	}

	public void remover(Long codigo) {
		DadosContaEnergia dadosContaEnergiaSalvo = buscarPeloCodigo(codigo);
		dadosContaEnergiaRepository.save(dadosContaEnergiaSalvo);
	}

	public Page<DadosContaEnergia> listarTodosAtivos(Pageable pageable) {
		return dadosContaEnergiaRepository.listarTodosAtivos(pageable);
	}

	public List<DadosContaEnergia> listarTodosAtivos() {
		return dadosContaEnergiaRepository.listarTodosAtivos();
	}

}