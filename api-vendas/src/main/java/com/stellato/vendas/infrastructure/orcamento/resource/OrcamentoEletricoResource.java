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
import com.stellato.vendas.domain.orcamentoMaterial.entity.OrcamentoMaterialEntity;
import com.stellato.vendas.infrastructure.orcamento.OrcamentoEletricoModel;
import com.stellato.vendas.infrastructure.orcamento.service.OrcamentoEletricoService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/orcamentoeletrico")
public class OrcamentoEletricoResource {

	@Autowired
	OrcamentoEletricoService orcamentoEletricoService;
	
	@ApiOperation(value = "Criar novo Orçamento Elétrico")
	@PostMapping()
	public ResponseEntity<OrcamentoEletricoEntity> createOrcamentoEletrico(@RequestBody OrcamentoEletricoEntity orcamentoEletricoEntity) throws Exception {
		OrcamentoEletricoEntity orcamentoEletricoEntitySave = orcamentoEletricoService.create(orcamentoEletricoEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(orcamentoEletricoEntitySave);
	}
	
	@ApiOperation(value = "Atualizar Orçamento Elétrico existente")
	@PutMapping("/{id}")
	public ResponseEntity<OrcamentoEletricoEntity> updateOrcamentoEletrico(@PathVariable Long id,@RequestBody OrcamentoEletricoEntity orcamentoEletricoEntity) throws Exception {
		OrcamentoEletricoEntity orcamentoEletricoEntityUpdated = orcamentoEletricoService.update(id,orcamentoEletricoEntity);
		return ResponseEntity.ok(orcamentoEletricoEntityUpdated);
	}
	
	@ApiOperation(value = "Buscar Orçamento Elétrico por id")
	@GetMapping("/{id}")
	public ResponseEntity<OrcamentoEletricoEntity> findOrcamentoEletrico(@PathVariable Long id) {
		return ResponseEntity.ok(orcamentoEletricoService.findById(id));
	}
	
	@ApiOperation(value = "Buscar todos Orçamentos Elétricos")
	@GetMapping("/all")
	public List<OrcamentoEletricoEntity> findAllOrcamentosEletrico() throws Exception {
		return orcamentoEletricoService.findAll();
	}
	
	@ApiOperation(value = "Buscar todos Orçamentos Elétricos ativos")
	@GetMapping("/ativos")
	public List<OrcamentoEletricoEntity> findAllOrcamentosEletricoActives() throws Exception {
		return orcamentoEletricoService.findAllActives();
	}
	
	@ApiOperation(value = "Buscar todos Orçamentos Elétricos ativos - paginado")
	@GetMapping("/ativos/paginado")
	public Page<OrcamentoEletricoEntity> findAllActivesPage(Pageable pageable) throws Exception {
		return orcamentoEletricoService.findAllActivesPage(pageable);
	}
	
	@ApiOperation(value = "Buscar orçamento através do Lead")
	@GetMapping("/lead/{idLead}")
	public List<OrcamentoEletricoEntity> findByLead(@PathVariable Long idLead) throws Exception {
		return orcamentoEletricoService.findByLead(idLead);
	}
	
	@ApiOperation(value = "Buscar orçamento através do Lead")
	@GetMapping("/lead/paginado/{idLead}")
	public Page<OrcamentoEletricoEntity> findByLeadPaginado(@PathVariable Long idLead, Pageable pageable) throws Exception {
		return orcamentoEletricoService.findByLead(idLead,pageable);
	}
	
	@ApiOperation(value = "Deletar Orçamentos Elétrico")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMaterialCotado(@PathVariable Long id) throws Exception {
		orcamentoEletricoService.deleteOrcamentoEletrico(id);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}
	
	@ApiOperation(value = "Serviço de teste")
	@GetMapping("/teste")
	public List<OrcamentoEletricoModel> teste() throws Exception {
		return orcamentoEletricoService.teste();
	}
	
	
	@ApiOperation(value = "Adicionar materiais no orçamento")
	@PutMapping("/addmateriais")
	public ResponseEntity<String> addMateriaisOrcamento(@RequestBody List<OrcamentoMaterialEntity> listaOrcamentoMaterial) throws Exception {
		orcamentoEletricoService.addListaMateriaisOrcamento(listaOrcamentoMaterial);
		return ResponseEntity.status(HttpStatus.OK).body("Materiais adicionados com sucesso");
	}
}
