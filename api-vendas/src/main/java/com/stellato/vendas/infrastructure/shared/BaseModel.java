package com.stellato.vendas.infrastructure.shared;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	private String codigo;
	
	protected Integer status;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate criadoEm;
	
	private Long criadoPor;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate alteradoEm;
	
	private Long alteradoPor;

}
