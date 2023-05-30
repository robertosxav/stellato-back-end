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

import com.stellato.model.Materialcotado;
import com.stellato.service.MaterialcotadoService;
import br.gov.mt.gestao.thanos.event.RecursoCriadoEvent;

@RestController
@RequestMapping("/materialcotados")
public class MaterialcotadoResource {

	@Autowired
	private MaterialcotadoService materialcotadoService;

	@Autowired
	private ApplicationEventPublisher publisher;

	@PostMapping
	public ResponseEntity<Materialcotado> criar(@Valid @RequestBody Materialcotado materialcotado, HttpServletResponse response) {
		 Materialcotado materialcotadoSalva = materialcotadoService.salvar(materialcotado);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, materialcotadoSalva.getMaterialcotadoid()));
		return ResponseEntity.status(HttpStatus.CREATED).body(materialcotadoSalva);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Materialcotado> buscarPeloCodigo(@PathVariable Long codigo) {
		Materialcotado materialcotado = materialcotadoService.buscarPeloCodigo(codigo);
		return materialcotado != null ? ResponseEntity.ok(materialcotado) : ResponseEntity.notFound().build();
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Materialcotado> atualizar(@PathVariable Long codigo, @Valid @RequestBody Materialcotado materialcotado) {
		Materialcotado materialcotadoSalva = materialcotadoService.atualizar(codigo, materialcotado);
		return ResponseEntity.ok(materialcotadoSalva);
	}

	@GetMapping
	public Page<Materialcotado> pesquisar(Pageable pageable) {
		return materialcotadoService.pesquisar(pageable);
	}

	@GetMapping("/all")
	public List<Materialcotado> pesquisar() {
		return materialcotadoService.listarTodos();
	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		materialcotadoService.remover(codigo);
	}

}