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

import com.stellato.model.MaterialCotado;
import com.stellato.service.MaterialCotadoService;

@RestController
@RequestMapping("/materialcotados")
public class MaterialCotadoResource {

	@Autowired
	private MaterialCotadoService materialcotadoService;

	@PostMapping
	public ResponseEntity<MaterialCotado> criar(@Valid @RequestBody MaterialCotado materialcotado, HttpServletResponse response) {
		 MaterialCotado materialcotadoSalva = materialcotadoService.salvar(materialcotado);
		return ResponseEntity.status(HttpStatus.CREATED).body(materialcotadoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<MaterialCotado> buscarPeloCodigo(@PathVariable Long codigo) {
		MaterialCotado materialcotado = materialcotadoService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(materialcotado);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<MaterialCotado> atualizar(@PathVariable Long codigo, @Valid @RequestBody MaterialCotado materialcotado) {
		MaterialCotado materialcotadoSalva = materialcotadoService.atualizar(codigo, materialcotado);
		return ResponseEntity.ok(materialcotadoSalva);
	}

	@GetMapping
	public Page<MaterialCotado> pesquisar(Pageable pageable) {
		return materialcotadoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<MaterialCotado> pesquisar() {
		return materialcotadoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		materialcotadoService.remover(codigo);
	}
	

	@GetMapping("/ativos/paginado")
	public Page<MaterialCotado> listarTodosAtivos(Pageable pageable) {
		return materialcotadoService.listarTodosAtivos(pageable);
	}

	@GetMapping("/ativos")
	public List<MaterialCotado> listarTodosAtivos() {
		return materialcotadoService.listarTodosAtivos();
	}

}