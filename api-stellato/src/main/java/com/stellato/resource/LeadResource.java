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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stellato.model.Lead;
import com.stellato.service.LeadService;

@RestController
@RequestMapping("/leads")
public class LeadResource {

	@Autowired
	private LeadService leadService;
	
	@PostMapping
	public ResponseEntity<Lead> criar(@Valid @RequestBody Lead lead, HttpServletResponse response) {
		 Lead leadSalva = leadService.salvar(lead);
		return ResponseEntity.status(HttpStatus.CREATED).body(leadSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Lead> buscarPeloCodigo(@PathVariable Long codigo) {
		Lead lead = leadService.buscarPeloCodigo(codigo);
		return lead != null ? ResponseEntity.ok(lead) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Lead> atualizar(@PathVariable Long codigo, @Valid @RequestBody Lead lead) {
		Lead leadSalva = leadService.atualizar(codigo, lead);
		return ResponseEntity.ok(leadSalva);
	}

	@GetMapping
	public Page<Lead> pesquisar(Pageable pageable) {
		return leadService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Lead> pesquisar() {
		return leadService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		leadService.remover(codigo);
	}

}