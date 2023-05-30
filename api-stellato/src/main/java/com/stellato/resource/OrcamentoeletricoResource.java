package com.stellato.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stellato.model.Orcamentoeletrico;
import com.stellato.service.OrcamentoeletricoService;
import br.gov.mt.gestao.thanos.event.RecursoCriadoEvent;

@RestController
@RequestMapping("/orcamentoeletricos")
public class OrcamentoeletricoResource {

	@Autowired
	private OrcamentoeletricoService orcamentoeletricoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Orcamentoeletrico> criar(@Valid @RequestBody Orcamentoeletrico orcamentoeletrico, HttpServletResponse response) {
		 Orcamentoeletrico orcamentoeletricoSalva = orcamentoeletricoService.salvar(orcamentoeletrico);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, orcamentoeletricoSalva.getOrcamentoeletricoid()));
		return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoeletricoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Orcamentoeletrico> buscarPeloCodigo(@PathVariable Long codigo) {
		Orcamentoeletrico orcamentoeletrico = orcamentoeletricoService.buscarPeloCodigo(codigo);
		return orcamentoeletrico != null ? ResponseEntity.ok(orcamentoeletrico) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Orcamentoeletrico> atualizar(@PathVariable Long codigo, @Valid @RequestBody Orcamentoeletrico orcamentoeletrico) {
		Orcamentoeletrico orcamentoeletricoSalva = orcamentoeletricoService.atualizar(codigo, orcamentoeletrico);
		return ResponseEntity.ok(orcamentoeletricoSalva);
	}

	@GetMapping
	public Page<Orcamentoeletrico> pesquisar(Pageable pageable) {
		return orcamentoeletricoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Orcamentoeletrico> pesquisar() {
		return orcamentoeletricoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		orcamentoeletricoService.remover(codigo);
	}

}