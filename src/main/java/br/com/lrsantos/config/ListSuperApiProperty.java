package br.com.lrsantos.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("listsuper")
public class ListSuperApiProperty {
	
	private String origemPermitida = "http://localhost:4200";

	public String getOrigemPermitida() {
		return origemPermitida;
	}

	public void setOrigemPermitida(String origemPermitida) {
		this.origemPermitida = origemPermitida;
	}
	
	

}
