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

import com.stellato.model.OrcamentoEleMatCotado;
import com.stellato.service.OrcamentoelematcotadoService;

@RestController
@RequestMapping("/orcamentoelematcotados")
public class OrcamentoEleMatCotadoResource {

	@Autowired
	private OrcamentoelematcotadoService orcamentoelematcotadoService;

	@PostMapping
	public ResponseEntity<OrcamentoEleMatCotado> criar(@Valid @RequestBody OrcamentoEleMatCotado orcamentoelematcotado, HttpServletResponse response) {
		 OrcamentoEleMatCotado orcamentoelematcotadoSalva = orcamentoelematcotadoService.salvar(orcamentoelematcotado);
		return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoelematcotadoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<OrcamentoEleMatCotado> buscarPeloCodigo(@PathVariable Long codigo) {
		OrcamentoEleMatCotado orcamentoelematcotado = orcamentoelematcotadoService.buscarPeloCodigo(codigo);
		return orcamentoelematcotado != null ? ResponseEntity.ok(orcamentoelematcotado) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<OrcamentoEleMatCotado> atualizar(@PathVariable Long codigo, @Valid @RequestBody OrcamentoEleMatCotado orcamentoelematcotado) {
		OrcamentoEleMatCotado orcamentoelematcotadoSalva = orcamentoelematcotadoService.atualizar(codigo, orcamentoelematcotado);
		return ResponseEntity.ok(orcamentoelematcotadoSalva);
	}

	@GetMapping
	public Page<OrcamentoEleMatCotado> pesquisar(Pageable pageable) {
		return orcamentoelematcotadoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<OrcamentoEleMatCotado> pesquisar() {
		return orcamentoelematcotadoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		orcamentoelematcotadoService.remover(codigo);
	}

}