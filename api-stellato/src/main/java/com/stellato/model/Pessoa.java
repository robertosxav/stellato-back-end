package com.stellato.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "public.pessoa") 
public class Pessoa implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pessoaid")
	private Long pessoaid;

	@Column(name = "pessoanome")
	private String pessoanome;

	@Column(name = "pessoacpf")
	private String pessoacpf;

	@Column(name = "pessoanomefantasia")
	private String pessoanomefantasia;

	@Column(name = "pessoacnpj")
	private String pessoacnpj;

	@Column(name = "pessoatelefone")
	private String pessoatelefone;

	@Column(name = "pessoawhatsapp")
	private String pessoawhatsapp;

	@Column(name = "pessoaemail")
	private String pessoaemail;

	@Column(name = "pessoatipopessoa")
	private Integer pessoatipopessoa;

	public Long getPessoaid() {
		return pessoaid;
	}
	 
	public void setPessoaid(Long pessoaid) {
		this.pessoaid = pessoaid;
	}
	 
	public String getPessoanome() {
		return pessoanome;
	}
	 
	public void setPessoanome(String pessoanome) {
		this.pessoanome = pessoanome;
	}
	 
	public String getPessoacpf() {
		return pessoacpf;
	}
	 
	public void setPessoacpf(String pessoacpf) {
		this.pessoacpf = pessoacpf;
	}
	 
	public String getPessoanomefantasia() {
		return pessoanomefantasia;
	}
	 
	public void setPessoanomefantasia(String pessoanomefantasia) {
		this.pessoanomefantasia = pessoanomefantasia;
	}
	 
	public String getPessoacnpj() {
		return pessoacnpj;
	}
	 
	public void setPessoacnpj(String pessoacnpj) {
		this.pessoacnpj = pessoacnpj;
	}
	 
	public String getPessoatelefone() {
		return pessoatelefone;
	}
	 
	public void setPessoatelefone(String pessoatelefone) {
		this.pessoatelefone = pessoatelefone;
	}
	 
	public String getPessoawhatsapp() {
		return pessoawhatsapp;
	}
	 
	public void setPessoawhatsapp(String pessoawhatsapp) {
		this.pessoawhatsapp = pessoawhatsapp;
	}
	 
	public String getPessoaemail() {
		return pessoaemail;
	}
	 
	public void setPessoaemail(String pessoaemail) {
		this.pessoaemail = pessoaemail;
	}
	 
	public Integer getPessoatipopessoa() {
		return pessoatipopessoa;
	}
	 
	public void setPessoatipopessoa(Integer pessoatipopessoa) {
		this.pessoatipopessoa = pessoatipopessoa;
	}
	 

} 
