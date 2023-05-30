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

import com.stellato.model.FlywaySchemaHistory;
import com.stellato.service.FlywaySchemaHistoryService;
import br.gov.mt.gestao.thanos.event.RecursoCriadoEvent;

@RestController
@RequestMapping("/flywayschemahistorys")
public class FlywaySchemaHistoryResource {

	@Autowired
	private FlywaySchemaHistoryService flywayschemahistoryService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<FlywaySchemaHistory> criar(@Valid @RequestBody FlywaySchemaHistory flywayschemahistory, HttpServletResponse response) {
		 FlywaySchemaHistory flywayschemahistorySalva = flywayschemahistoryService.salvar(flywayschemahistory);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, flywayschemahistorySalva.getInstalledRank()));
		return ResponseEntity.status(HttpStatus.CREATED).body(flywayschemahistorySalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<FlywaySchemaHistory> buscarPeloCodigo(@PathVariable Long codigo) {
		FlywaySchemaHistory flywayschemahistory = flywayschemahistoryService.buscarPeloCodigo(codigo);
		return flywayschemahistory != null ? ResponseEntity.ok(flywayschemahistory) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<FlywaySchemaHistory> atualizar(@PathVariable Long codigo, @Valid @RequestBody FlywaySchemaHistory flywayschemahistory) {
		FlywaySchemaHistory flywayschemahistorySalva = flywayschemahistoryService.atualizar(codigo, flywayschemahistory);
		return ResponseEntity.ok(flywayschemahistorySalva);
	}

	@GetMapping
	public Page<FlywaySchemaHistory> pesquisar(Pageable pageable) {
		return flywayschemahistoryService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<FlywaySchemaHistory> pesquisar() {
		return flywayschemahistoryService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		flywayschemahistoryService.remover(codigo);
	}

}