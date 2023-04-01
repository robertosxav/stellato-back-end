package com.stellato.vendas.domain.shared;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stellato.vendas.domain.shared.enumerated.StatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor()
@AllArgsConstructor
public abstract class BaseEntity implements BaseEntityInterface{
	private String codigo;
	
	private StatusEnum status;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate criadoEm;
	
	private Long criadoPor;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate alteradoEm;
	
	private Long alteradoPor;

	@Override
	public void Ativar() {
		this.setCodigo(gerarUUID());
		this.setStatus(StatusEnum.ATIVO);
		this.setCriadoEm(LocalDate.now());		
	}
	
	@Override
	public void Alterar(Long id) {
		this.setStatus(StatusEnum.ATIVO);
		this.setAlteradoEm(LocalDate.now());	
		this.setAlteradoPor(id);	
	}

	@Override
	public void Inativar() {
		this.setStatus(StatusEnum.ATIVO);
	}
	
	@Override
	public String gerarUUID() {
		UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();

        return uuidAsString;
	}

	public BaseEntity(String codigo, Integer statusNumero, LocalDate criadoEm, Long criadoPor, LocalDate alteradoEm,
			Long alteradoPor) {
		super();
		this.codigo = codigo;
		this.status = StatusEnum.toEnum(statusNumero);
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}
	
	public BaseEntity(String codigo, LocalDate criadoEm, Long criadoPor, LocalDate alteradoEm,
			Long alteradoPor) {
		super();
		this.codigo = codigo;
		this.criadoEm = criadoEm;
		this.criadoPor = criadoPor;
		this.alteradoEm = alteradoEm;
		this.alteradoPor = alteradoPor;
	}
	
}
