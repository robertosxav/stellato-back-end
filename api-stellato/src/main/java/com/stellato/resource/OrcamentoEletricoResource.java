package com.stellato.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stellato.model.OrcamentoEletrico;
import com.stellato.service.OrcamentoEletricoService;

@RestController
@RequestMapping("/orcamentoeletrico")
public class OrcamentoEletricoResource {

	@Autowired
	private OrcamentoEletricoService orcamentoeletricoService;

	@PostMapping
	public ResponseEntity<OrcamentoEletrico> criar(@Valid @RequestBody OrcamentoEletrico orcamentoeletrico, HttpServletResponse response) {
		 OrcamentoEletrico orcamentoeletricoSalva = orcamentoeletricoService.salvar(orcamentoeletrico);
		return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoeletricoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrcamentoEletrico> buscarPeloCodigo(@PathVariable Long codigo) {
		OrcamentoEletrico orcamentoeletrico = orcamentoeletricoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(orcamentoeletrico);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrcamentoEletrico> atualizar(@PathVariable Long codigo, @Valid @RequestBody OrcamentoEletrico orcamentoeletrico) {
		OrcamentoEletrico orcamentoeletricoSalva = orcamentoeletricoService.atualizar(codigo, orcamentoeletrico);
		return ResponseEntity.ok(orcamentoeletricoSalva);
	}

	@GetMapping
	public Page<OrcamentoEletrico> pesquisar(Pageable pageable) {
		return orcamentoeletricoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<OrcamentoEletrico> pesquisar() {
		return orcamentoeletricoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		orcamentoeletricoService.remover(codigo);
	}

}