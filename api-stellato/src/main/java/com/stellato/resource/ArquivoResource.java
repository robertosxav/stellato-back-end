package com.stellato.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
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

import com.stellato.model.Arquivo;
import com.stellato.service.ArquivoService;
import br.gov.mt.gestao.thanos.event.RecursoCriadoEvent;

@RestController
@RequestMapping("/arquivos")
public class ArquivoResource {

	@Autowired
	private ArquivoService arquivoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Arquivo> criar(@Valid @RequestBody Arquivo arquivo, HttpServletResponse response) {
		 Arquivo arquivoSalva = arquivoService.salvar(arquivo);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, arquivoSalva.getArquivoid()));
		return ResponseEntity.status(HttpStatus.CREATED).body(arquivoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Arquivo> buscarPeloCodigo(@PathVariable Long codigo) {
		Arquivo arquivo = arquivoService.buscarPeloCodigo(codigo);
		return arquivo != null ? ResponseEntity.ok(arquivo) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Arquivo> atualizar(@PathVariable Long codigo, @Valid @RequestBody Arquivo arquivo) {
		Arquivo arquivoSalva = arquivoService.atualizar(codigo, arquivo);
		return ResponseEntity.ok(arquivoSalva);
	}

	@GetMapping
	public Page<Arquivo> pesquisar(Pageable pageable) {
		return arquivoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Arquivo> pesquisar() {
		return arquivoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		arquivoService.remover(codigo);
	}

}