package com.stellato.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.Distribuidora;
import com.stellato.model.ParamModTarifaria;
import com.stellato.repository.ParamModTarifariaRepository;

@Service
public class ParamModTarifariaService {

	@Autowired
	private ParamModTarifariaRepository paramModTarifariaRepository;
	
	@Autowired
	private DistribuidoraService distribuidoraService;


	public ParamModTarifaria salvar(ParamModTarifaria modalidadeTarifaria) {
		validar(modalidadeTarifaria);
		modalidadeTarifaria.ativar();
		return paramModTarifariaRepository.save(modalidadeTarifaria);
	}

	
	private void validar(ParamModTarifaria modalidadeTarifaria) {
		
		Boolean isMaiorQueZero = modalidadeTarifaria.getValor().compareTo(BigDecimal.ZERO)==1?true:false;
		
		if(!isMaiorQueZero) {
			throw new StellatoException("Valor deve ser maior que zero");
		}
		
		Distribuidora distribuidora = distribuidoraService.buscarPeloCodigo(modalidadeTarifaria.getDistribuidora().getId());
		modalidadeTarifaria.setDistribuidora(distribuidora);
	}

	public ParamModTarifaria buscarPeloCodigo(Long codigo) {
		ParamModTarifaria modalidadeTarifariaSalva = paramModTarifariaRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		return modalidadeTarifariaSalva;
	}

	public ParamModTarifaria atualizar(Long codigo, ParamModTarifaria modalidadeTarifaria) {
		validar(modalidadeTarifaria);
		ParamModTarifaria modalidadeTarifariaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(modalidadeTarifaria, modalidadeTarifariaSave, "id","status");
		return paramModTarifariaRepository.save(modalidadeTarifariaSave);
	}

	public Page<ParamModTarifaria> pesquisar(Pageable pageable){
		return paramModTarifariaRepository.findAll(pageable);
	}

	public List<ParamModTarifaria> listarTodos() {
		return paramModTarifariaRepository.findAll();
	}

	public void remover(Long codigo) {
		ParamModTarifaria modalidadeTarifaria = buscarPeloCodigo(codigo);
		modalidadeTarifaria.inativar();
		paramModTarifariaRepository.save(modalidadeTarifaria);
	}

	public Page<ParamModTarifaria> listarTodosAtivos(Pageable pageable) {
		return paramModTarifariaRepository.listarTodosAtivos(pageable);
	}

	public List<ParamModTarifaria> listarTodosAtivos() {
		return paramModTarifariaRepository.listarTodosAtivos();
	}


	public List<ParamModTarifaria> buscarPelaDistribuidora(Long idDistribuidora) {
		return paramModTarifariaRepository.buscarPelaDistribuidora(idDistribuidora);
	}


}