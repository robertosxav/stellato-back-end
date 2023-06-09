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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stellato.model.Fornecedor;
import com.stellato.service.FornecedorService;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorResource {

	@Autowired
	private FornecedorService fornecedorService;

	@PostMapping
	public ResponseEntity<Fornecedor> criar(@Valid @RequestBody Fornecedor fornecedor, HttpServletResponse response) {
		 Fornecedor fornecedorSalva = fornecedorService.salvar(fornecedor);
		return ResponseEntity.status(HttpStatus.CREATED).body(fornecedorSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Fornecedor> buscarPeloCodigo(@PathVariable Long codigo) {
		Fornecedor fornecedor = fornecedorService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(fornecedor);
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
	public void remover(@PathVariable Long codigo) {
		fornecedorService.remover(codigo);
	}
	
	@GetMapping("/ativos/paginado")
	public Page<Fornecedor> listarTodosAtivos(Pageable pageable) {
		return fornecedorService.listarTodosAtivos(pageable);
	}

	@GetMapping("/ativos")
	public List<Fornecedor> listarTodosAtivos() {
		return fornecedorService.listarTodosAtivos();
	}
	
	@GetMapping("/buscagenerica")
	public Page<Fornecedor> buscaGenerica(@RequestParam String pesquisa,Pageable pageable) {
		return fornecedorService.buscaGenerica(pesquisa,pageable);
	}


}