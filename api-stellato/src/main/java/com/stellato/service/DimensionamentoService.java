package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.Dimensionamento;
import com.stellato.model.OrcamentoEletrico;
import com.stellato.repository.DimensionamentoRepository;

@Service
public class DimensionamentoService {

	@Autowired
	private DimensionamentoRepository dimensionamentoRepository;
	
	@Autowired
	private OrcamentoEletricoService orcamentoEletricoService;

	public Dimensionamento salvar(Dimensionamento dimensionamento) {
		validar(dimensionamento);
		dimensionamento.ativar();
		return dimensionamentoRepository.save(dimensionamento);
	}

	private void validar(Dimensionamento dimensionamento) {
		OrcamentoEletrico orcamentoEletrico = orcamentoEletricoService
				.buscarPeloCodigo(dimensionamento.getOrcamentoEletrico().getId());
		
		dimensionamento.setOrcamentoEletrico(orcamentoEletrico);
		
	}

	public Dimensionamento buscarPeloCodigo(Long codigo) {
		Dimensionamento dimensionamentoSalva = dimensionamentoRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		
		return dimensionamentoSalva;
	}

	public Dimensionamento atualizar(Long codigo, Dimensionamento dimensionamento) {
		Dimensionamento dimensionamentoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(dimensionamento, dimensionamentoSave, "id","status");
		return dimensionamentoRepository.save(dimensionamentoSave);
	}

	public Page<Dimensionamento> pesquisar(Pageable pageable){
		return dimensionamentoRepository.findAll(pageable);
	}

	public List<Dimensionamento> listarTodos() {
		return dimensionamentoRepository.findAll();
	}

	public void remover(Long codigo) {
		Dimensionamento dimensionamentoSalvo = buscarPeloCodigo(codigo);
		dimensionamentoSalvo.inativar();
		dimensionamentoRepository.save(dimensionamentoSalvo);
	}

	public Page<Dimensionamento> listarTodosAtivos(Pageable pageable) {
		return dimensionamentoRepository.listarTodosAtivos(pageable);
	}

	public List<Dimensionamento> listarTodosAtivos() {
		return dimensionamentoRepository.listarTodosAtivos();
	}

}