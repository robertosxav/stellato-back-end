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
import org.springframework.web.bind.annotation.RestController;

import com.stellato.model.Dimensionamento;
import com.stellato.service.DimensionamentoService;

@RestController
@RequestMapping("/dimensionamento")
public class DimensionamentoResource {

	@Autowired
	private DimensionamentoService dimensionamentoService;

	@PostMapping
	public ResponseEntity<Dimensionamento> criar(@Valid @RequestBody Dimensionamento dimensionamento, HttpServletResponse response) {
		 Dimensionamento dimensionamentoSalva = dimensionamentoService.salvar(dimensionamento);
		return ResponseEntity.status(HttpStatus.CREATED).body(dimensionamentoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Dimensionamento> buscarPeloCodigo(@PathVariable Long codigo) {
		Dimensionamento dimensionamento = dimensionamentoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(dimensionamento);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Dimensionamento> atualizar(@PathVariable Long codigo, @Valid @RequestBody Dimensionamento dimensionamento) {
		Dimensionamento dimensionamentoSalva = dimensionamentoService.atualizar(codigo, dimensionamento);
		return ResponseEntity.ok(dimensionamentoSalva);
	}

	@GetMapping
	public Page<Dimensionamento> pesquisar(Pageable pageable) {
		return dimensionamentoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Dimensionamento> pesquisar() {
		return dimensionamentoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		dimensionamentoService.remover(codigo);
	}
	
	@GetMapping("/ativos/paginado")
	public Page<Dimensionamento> listarTodosAtivos(Pageable pageable) {
		return dimensionamentoService.listarTodosAtivos(pageable);
	}

	@GetMapping("/ativos")
	public List<Dimensionamento> listarTodosAtivos() {
		return dimensionamentoService.listarTodosAtivos();
	}

}