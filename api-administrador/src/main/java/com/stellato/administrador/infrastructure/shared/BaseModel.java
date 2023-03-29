package com.stellato.administrador.infrastructure.shared;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

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
	
	private Integer status;
	
	private LocalDate criadoEm;
	
	private Long criadoPor;
	
	private LocalDate alteradoEm;
	
	private Long alteradoPor;

}
