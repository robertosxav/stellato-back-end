package com.stellato.vendas.infrastructure.orcamento.resource;

import java.util.List;

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

import com.stellato.vendas.domain.orcamento.entity.OrcamentoEletricoEntity;
import com.stellato.vendas.infrastructure.orcamento.service.OrcamentoEletricoService;


@RestController
@RequestMapping("/orcamentoeletrico")
public class OrcamentoEletricoResource {

	@Autowired
	OrcamentoEletricoService orcamentoEletricoService;
	
	@PostMapping()
	public ResponseEntity<OrcamentoEletricoEntity> createOrcamentoEletrico(@RequestBody OrcamentoEletricoEntity orcamentoEletricoEntity) throws Exception {
		OrcamentoEletricoEntity orcamentoEletricoEntitySave = orcamentoEletricoService.create(orcamentoEletricoEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoEletricoEntitySave);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<OrcamentoEletricoEntity> updateOrcamentoEletrico(@PathVariable Long id,@RequestBody OrcamentoEletricoEntity orcamentoEletricoEntity) throws Exception {
		OrcamentoEletricoEntity orcamentoEletricoEntityUpdated = orcamentoEletricoService.update(id,orcamentoEletricoEntity);
		return ResponseEntity.ok(orcamentoEletricoEntityUpdated);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrcamentoEletricoEntity> findOrcamentoEletrico(@PathVariable Long id) {
		return ResponseEntity.ok(orcamentoEletricoService.findById(id));
	}
	
	@GetMapping("/all")
	public List<OrcamentoEletricoEntity> findAllOrcamentosEletrico() throws Exception {
		return orcamentoEletricoService.findAll();
	}
	
	@GetMapping("/ativos")
	public List<OrcamentoEletricoEntity> findAllOrcamentosEletricoActives() throws Exception {
		return orcamentoEletricoService.findAllActives();
	}
	
	@GetMapping("/ativos/paginado")
	public Page<OrcamentoEletricoEntity> findAllActivesPage(Pageable pageable) throws Exception {
		return orcamentoEletricoService.findAllActivesPage(pageable);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMaterialCotado(@PathVariable Long id) throws Exception {
		orcamentoEletricoService.deleteOrcamentoEletrico(id);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
}
