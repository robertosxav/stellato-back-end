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

import com.stellato.model.Pessoa;
import com.stellato.service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping
	public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response) {
		 Pessoa pessoaSalva = pessoaService.salvar(pessoa);
		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo) {
		Pessoa pessoa = pessoaService.buscarPeloCodigo(codigo);
		return ResponseEntity.ok(pessoa);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);
		return ResponseEntity.ok(pessoaSalva);
	}

	@GetMapping
	public Page<Pessoa> pesquisar(Pageable pageable) {
		return pessoaService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Pessoa> pesquisar() {
		return pessoaService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	public void remover(@PathVariable Long codigo) {
		pessoaService.remover(codigo);
	}
	
	@GetMapping("/ativos/paginado")
	public Page<Pessoa> listarTodosAtivos(Pageable pageable) {
		return pessoaService.listarTodosAtivos(pageable);
	}

	@GetMapping("/ativos")
	public List<Pessoa> listarTodosAtivos() {
		return pessoaService.listarTodosAtivos();
	}
	
	@GetMapping("/buscagenerica")
	public Page<Pessoa> buscaGenerica(@RequestParam String pesquisa,Pageable pageable) {
		return pessoaService.buscaGenerica(pesquisa,pageable);
	}

}