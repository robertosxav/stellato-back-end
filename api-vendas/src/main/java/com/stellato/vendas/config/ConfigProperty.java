package com.stellato.vendas.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("config")
public class ConfigProperty {
	private String originPermitida = "http://localhost:8080";
	
	public String getOriginPermitida() {
		return originPermitida;
	}

	public void setOriginPermitida(String originPermitida) {
		this.originPermitida = originPermitida;
	}

}