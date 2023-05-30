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

import com.stellato.model.Etapasfunil;
import com.stellato.service.EtapasfunilService;
import br.gov.mt.gestao.thanos.event.RecursoCriadoEvent;

@RestController
@RequestMapping("/etapasfunils")
public class EtapasfunilResource {

	@Autowired
	private EtapasfunilService etapasfunilService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Etapasfunil> criar(@Valid @RequestBody Etapasfunil etapasfunil, HttpServletResponse response) {
		 Etapasfunil etapasfunilSalva = etapasfunilService.salvar(etapasfunil);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, etapasfunilSalva.getEtapasfunilid()));
		return ResponseEntity.status(HttpStatus.CREATED).body(etapasfunilSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Etapasfunil> buscarPeloCodigo(@PathVariable Long codigo) {
		Etapasfunil etapasfunil = etapasfunilService.buscarPeloCodigo(codigo);
		return etapasfunil != null ? ResponseEntity.ok(etapasfunil) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Etapasfunil> atualizar(@PathVariable Long codigo, @Valid @RequestBody Etapasfunil etapasfunil) {
		Etapasfunil etapasfunilSalva = etapasfunilService.atualizar(codigo, etapasfunil);
		return ResponseEntity.ok(etapasfunilSalva);
	}

	@GetMapping
	public Page<Etapasfunil> pesquisar(Pageable pageable) {
		return etapasfunilService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Etapasfunil> pesquisar() {
		return etapasfunilService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		etapasfunilService.remover(codigo);
	}

}