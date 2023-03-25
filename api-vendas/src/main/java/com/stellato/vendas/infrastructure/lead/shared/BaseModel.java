package com.stellato.vendas.infrastructure.lead.shared;

import java.time.LocalDate;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor()
@AllArgsConstructor
public class BaseModel {
	
	protected Integer status;
	
	private LocalDate criadoEm;
	
	private Long criadoPor;
	
	private LocalDate alteradoEm;
	
	private Long alteradoPor;

}
