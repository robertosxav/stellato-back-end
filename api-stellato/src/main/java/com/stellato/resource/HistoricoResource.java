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

import com.stellato.model.Historico;
import com.stellato.service.HistoricoService;
import br.gov.mt.gestao.thanos.event.RecursoCriadoEvent;

@RestController
@RequestMapping("/historicos")
public class HistoricoResource {

	@Autowired
	private HistoricoService historicoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Historico> criar(@Valid @RequestBody Historico historico, HttpServletResponse response) {
		 Historico historicoSalva = historicoService.salvar(historico);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, historicoSalva.getHistoricoid()));
		return ResponseEntity.status(HttpStatus.CREATED).body(historicoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Historico> buscarPeloCodigo(@PathVariable Long codigo) {
		Historico historico = historicoService.buscarPeloCodigo(codigo);
		return historico != null ? ResponseEntity.ok(historico) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Historico> atualizar(@PathVariable Long codigo, @Valid @RequestBody Historico historico) {
		Historico historicoSalva = historicoService.atualizar(codigo, historico);
		return ResponseEntity.ok(historicoSalva);
	}

	@GetMapping
	public Page<Historico> pesquisar(Pageable pageable) {
		return historicoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Historico> pesquisar() {
		return historicoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		historicoService.remover(codigo);
	}

}