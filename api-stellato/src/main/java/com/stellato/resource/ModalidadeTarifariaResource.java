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

import com.stellato.model.ModalidadeTarifaria;
import com.stellato.service.ModalidadetarifariaService;

@RestController
@RequestMapping("/modalidadetarifarias")
public class ModalidadeTarifariaResource {

	@Autowired
	private ModalidadetarifariaService modalidadetarifariaService;

	@PostMapping
	public ResponseEntity<ModalidadeTarifaria> criar(@Valid @RequestBody ModalidadeTarifaria modalidadetarifaria, HttpServletResponse response) {
		 ModalidadeTarifaria modalidadetarifariaSalva = modalidadetarifariaService.salvar(modalidadetarifaria);
		return ResponseEntity.status(HttpStatus.CREATED).body(modalidadetarifariaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<ModalidadeTarifaria> buscarPeloCodigo(@PathVariable Long codigo) {
		ModalidadeTarifaria modalidadetarifaria = modalidadetarifariaService.buscarPeloCodigo(codigo);
		return modalidadetarifaria != null ? ResponseEntity.ok(modalidadetarifaria) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<ModalidadeTarifaria> atualizar(@PathVariable Long codigo, @Valid @RequestBody ModalidadeTarifaria modalidadetarifaria) {
		ModalidadeTarifaria modalidadetarifariaSalva = modalidadetarifariaService.atualizar(codigo, modalidadetarifaria);
		return ResponseEntity.ok(modalidadetarifariaSalva);
	}

	@GetMapping
	public Page<ModalidadeTarifaria> pesquisar(Pageable pageable) {
		return modalidadetarifariaService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<ModalidadeTarifaria> pesquisar() {
		return modalidadetarifariaService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		modalidadetarifariaService.remover(codigo);
	}

}