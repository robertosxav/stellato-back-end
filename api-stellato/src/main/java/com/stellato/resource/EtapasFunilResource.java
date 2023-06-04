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

import com.stellato.model.EtapasFunil;
import com.stellato.service.EtapasfunilService;

@RestController
@RequestMapping("/etapasfunils")
public class EtapasFunilResource {

	@Autowired
	private EtapasfunilService etapasfunilService;

	@PostMapping
	public ResponseEntity<EtapasFunil> criar(@Valid @RequestBody EtapasFunil etapasfunil, HttpServletResponse response) {
		 EtapasFunil etapasfunilSalva = etapasfunilService.salvar(etapasfunil);
		return ResponseEntity.status(HttpStatus.CREATED).body(etapasfunilSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<EtapasFunil> buscarPeloCodigo(@PathVariable Long codigo) {
		EtapasFunil etapasfunil = etapasfunilService.buscarPeloCodigo(codigo);
		return etapasfunil != null ? ResponseEntity.ok(etapasfunil) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<EtapasFunil> atualizar(@PathVariable Long codigo, @Valid @RequestBody EtapasFunil etapasfunil) {
		EtapasFunil etapasfunilSalva = etapasfunilService.atualizar(codigo, etapasfunil);
		return ResponseEntity.ok(etapasfunilSalva);
	}

	@GetMapping
	public Page<EtapasFunil> pesquisar(Pageable pageable) {
		return etapasfunilService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<EtapasFunil> pesquisar() {
		return etapasfunilService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		etapasfunilService.remover(codigo);
	}

}