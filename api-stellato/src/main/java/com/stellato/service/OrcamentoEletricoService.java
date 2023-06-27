package com.stellato.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.stellato.exceptions.StellatoException;
import com.stellato.model.EtapasFunil;
import com.stellato.model.OrcamentoEletrico;
import com.stellato.repository.OrcamentoEletricoRepository;

@Service
public class OrcamentoEletricoService {

	@Autowired
	private OrcamentoEletricoRepository orcamentoEletricoRepository;
	
	@Autowired
	private EtapasFunilService etapasFunilService;

	public OrcamentoEletrico salvar(OrcamentoEletrico orcamentoEletrico) {
		validar(orcamentoEletrico);
		orcamentoEletrico.ativar();
		return orcamentoEletricoRepository.save(orcamentoEletrico);
	}

	private void validar(OrcamentoEletrico orcamentoEletrico) {
		EtapasFunil etapasFunil = etapasFunilService.buscarPeloCodigo(orcamentoEletrico.getEtapasFunil().getId());
		orcamentoEletrico.setEtapasFunil(etapasFunil);
	}

	public OrcamentoEletrico buscarPeloCodigo(Long codigo) {
		OrcamentoEletrico orcamentoEletricoSalva = orcamentoEletricoRepository
				.findById(codigo)
				.orElseThrow(()-> new StellatoException("Id não encontrado"));
		return orcamentoEletricoSalva;
	}

	public OrcamentoEletrico atualizar(Long codigo, OrcamentoEletrico orcamentoEletrico) {
		OrcamentoEletrico orcamentoEletricoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(orcamentoEletrico, orcamentoEletricoSave, "id","status");
		return orcamentoEletricoRepository.save(orcamentoEletricoSave);
	}

	public Page<OrcamentoEletrico> pesquisar(Pageable pageable){
		return orcamentoEletricoRepository.findAll(pageable);
	}

	public List<OrcamentoEletrico> listarTodos() {
		return orcamentoEletricoRepository.findAll();
	}

	public void remover(Long codigo) {
		OrcamentoEletrico orcamentoEletrico = buscarPeloCodigo(codigo);
		orcamentoEletrico.inativar();
		orcamentoEletricoRepository.save(orcamentoEletrico);
	}

	public Page<OrcamentoEletrico> buscarPeloLead(Long idLead, Pageable pageable) {
		return orcamentoEletricoRepository.findByLeadId(idLead,pageable);
	}

}