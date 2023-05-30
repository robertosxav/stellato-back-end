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

import com.stellato.model.Fornecedor;
import com.stellato.service.FornecedorService;
import br.gov.mt.gestao.thanos.event.RecursoCriadoEvent;

@RestController
@RequestMapping("/fornecedors")
public class FornecedorResource {

	@Autowired
	private FornecedorService fornecedorService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Fornecedor> criar(@Valid @RequestBody Fornecedor fornecedor, HttpServletResponse response) {
		 Fornecedor fornecedorSalva = fornecedorService.salvar(fornecedor);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, fornecedorSalva.getFornecedorid()));
		return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Fornecedor> buscarPeloCodigo(@PathVariable Long codigo) {
		Fornecedor fornecedor = fornecedorService.buscarPeloCodigo(codigo);
		return fornecedor != null ? ResponseEntity.ok(fornecedor) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Fornecedor> atualizar(@PathVariable Long codigo, @Valid @RequestBody Fornecedor fornecedor) {
		Fornecedor fornecedorSalva = fornecedorService.atualizar(codigo, fornecedor);
		return ResponseEntity.ok(fornecedorSalva);
	}

	@GetMapping
	public Page<Fornecedor> pesquisar(Pageable pageable) {
		return fornecedorService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Fornecedor> pesquisar() {
		return fornecedorService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		fornecedorService.remover(codigo);
	}

}