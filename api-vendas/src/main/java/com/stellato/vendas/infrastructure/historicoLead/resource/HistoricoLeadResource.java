package com.stellato.vendas.infrastructure.historicoLead.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/histlead")
public class HistoricoLeadResource {
	
/*	@Autowired
	HistoricoLeadService histLeadService;
	
	@PostMapping()
	public ResponseEntity<HistoricoLeadEntity> createLead(@RequestBody HistoricoLeadEntity HistoricoLeadEntity) throws Exception {
		HistoricoLeadEntity HistoricoLeadEntitySave = histLeadService.create(HistoricoLeadEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(HistoricoLeadEntitySave);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<HistoricoLeadEntity> updateLead(@PathVariable BigDecimal id,@RequestBody HistoricoLeadEntity HistoricoLeadEntity) throws Exception {
	//	HistoricoLeadEntity HistoricoLeadEntityUpdated = histLeadService.update(id,HistoricoLeadEntity);
		//return ResponseEntity.ok(HistoricoLeadEntityUpdated);
		return null;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<HistoricoLeadEntity> findHistLead(@PathVariable BigDecimal id) {
		return ResponseEntity.ok(histLeadService.findById(id));
	}
	
	@GetMapping("/all")
	public List<HistoricoLeadEntity> findAllLeads() throws Exception {
		return histLeadService.findAll();
	}
	
	/*@GetMapping("/ativos")
	public List<com.stellato.vendas.domain.historicoLead.entity.HistoricoLeadEntity> findAllLeadsActives() throws Exception {
		return histLeadService.findAllActives();
	}
	*/
	
/*	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteHistLead(@PathVariable BigDecimal id) throws Exception {
		histLeadService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).body("Registro deletado com sucesso");
	}*/
}
