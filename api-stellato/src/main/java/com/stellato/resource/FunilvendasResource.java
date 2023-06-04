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

import com.stellato.model.Funilvendas;
import com.stellato.service.FunilvendasService;

@RestController
@RequestMapping("/funilvendas")
public class FunilvendasResource {

	@Autowired
	private FunilvendasService funilvendasService;

	@PostMapping
	public ResponseEntity<Funilvendas> criar(@Valid @RequestBody Funilvendas funilvendas, HttpServletResponse response) {
		 Funilvendas funilvendasSalva = funilvendasService.salvar(funilvendas);
		return ResponseEntity.status(HttpStatus.CREATED).body(funilvendasSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Funilvendas> buscarPeloCodigo(@PathVariable Long codigo) {
		Funilvendas funilvendas = funilvendasService.buscarPeloCodigo(codigo);
		return funilvendas != null ? ResponseEntity.ok(funilvendas) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Funilvendas> atualizar(@PathVariable Long codigo, @Valid @RequestBody Funilvendas funilvendas) {
		Funilvendas funilvendasSalva = funilvendasService.atualizar(codigo, funilvendas);
		return ResponseEntity.ok(funilvendasSalva);
	}

	@GetMapping
	public Page<Funilvendas> pesquisar(Pageable pageable) {
		return funilvendasService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Funilvendas> pesquisar() {
		return funilvendasService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		funilvendasService.remover(codigo);
	}

}