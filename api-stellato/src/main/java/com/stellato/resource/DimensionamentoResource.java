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

import com.stellato.model.Dimensionamento;
import com.stellato.service.DimensionamentoService;
import br.gov.mt.gestao.thanos.event.RecursoCriadoEvent;

@RestController
@RequestMapping("/dimensionamentos")
public class DimensionamentoResource {

	@Autowired
	private DimensionamentoService dimensionamentoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Dimensionamento> criar(@Valid @RequestBody Dimensionamento dimensionamento, HttpServletResponse response) {
		 Dimensionamento dimensionamentoSalva = dimensionamentoService.salvar(dimensionamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, dimensionamentoSalva.getDimensionamentoid()));
		return ResponseEntity.status(HttpStatus.CREATED).body(dimensionamentoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Dimensionamento> buscarPeloCodigo(@PathVariable Long codigo) {
		Dimensionamento dimensionamento = dimensionamentoService.buscarPeloCodigo(codigo);
		return dimensionamento != null ? ResponseEntity.ok(dimensionamento) : ResponseEntity.notFound().build();
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
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		dimensionamentoService.remover(codigo);
	}

}