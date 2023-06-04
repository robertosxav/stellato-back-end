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

import com.stellato.model.Modalidadetarifaria;
import com.stellato.service.ModalidadetarifariaService;

@RestController
@RequestMapping("/modalidadetarifarias")
public class ModalidadeTarifariaResource {

	@Autowired
	private ModalidadetarifariaService modalidadetarifariaService;

	@PostMapping
	public ResponseEntity<Modalidadetarifaria> criar(@Valid @RequestBody Modalidadetarifaria modalidadetarifaria, HttpServletResponse response) {
		 Modalidadetarifaria modalidadetarifariaSalva = modalidadetarifariaService.salvar(modalidadetarifaria);
		return ResponseEntity.status(HttpStatus.CREATED).body(modalidadetarifariaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Modalidadetarifaria> buscarPeloCodigo(@PathVariable Long codigo) {
		Modalidadetarifaria modalidadetarifaria = modalidadetarifariaService.buscarPeloCodigo(codigo);
		return modalidadetarifaria != null ? ResponseEntity.ok(modalidadetarifaria) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Modalidadetarifaria> atualizar(@PathVariable Long codigo, @Valid @RequestBody Modalidadetarifaria modalidadetarifaria) {
		Modalidadetarifaria modalidadetarifariaSalva = modalidadetarifariaService.atualizar(codigo, modalidadetarifaria);
		return ResponseEntity.ok(modalidadetarifariaSalva);
	}

	@GetMapping
	public Page<Modalidadetarifaria> pesquisar(Pageable pageable) {
		return modalidadetarifariaService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Modalidadetarifaria> pesquisar() {
		return modalidadetarifariaService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		modalidadetarifariaService.remover(codigo);
	}

}