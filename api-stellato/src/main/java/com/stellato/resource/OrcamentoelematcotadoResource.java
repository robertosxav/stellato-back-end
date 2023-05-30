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

import com.stellato.model.Orcamentoelematcotado;
import com.stellato.service.OrcamentoelematcotadoService;
import br.gov.mt.gestao.thanos.event.RecursoCriadoEvent;

@RestController
@RequestMapping("/orcamentoelematcotados")
public class OrcamentoelematcotadoResource {

	@Autowired
	private OrcamentoelematcotadoService orcamentoelematcotadoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Orcamentoelematcotado> criar(@Valid @RequestBody Orcamentoelematcotado orcamentoelematcotado, HttpServletResponse response) {
		 Orcamentoelematcotado orcamentoelematcotadoSalva = orcamentoelematcotadoService.salvar(orcamentoelematcotado);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, orcamentoelematcotadoSalva.getOrcamentoelematcotadoid()));
		return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoelematcotadoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Orcamentoelematcotado> buscarPeloCodigo(@PathVariable Long codigo) {
		Orcamentoelematcotado orcamentoelematcotado = orcamentoelematcotadoService.buscarPeloCodigo(codigo);
		return orcamentoelematcotado != null ? ResponseEntity.ok(orcamentoelematcotado) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Orcamentoelematcotado> atualizar(@PathVariable Long codigo, @Valid @RequestBody Orcamentoelematcotado orcamentoelematcotado) {
		Orcamentoelematcotado orcamentoelematcotadoSalva = orcamentoelematcotadoService.atualizar(codigo, orcamentoelematcotado);
		return ResponseEntity.ok(orcamentoelematcotadoSalva);
	}

	@GetMapping
	public Page<Orcamentoelematcotado> pesquisar(Pageable pageable) {
		return orcamentoelematcotadoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Orcamentoelematcotado> pesquisar() {
		return orcamentoelematcotadoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		orcamentoelematcotadoService.remover(codigo);
	}

}