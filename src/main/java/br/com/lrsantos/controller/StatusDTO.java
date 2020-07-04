package br.com.lrsantos.controller;

import java.time.LocalDateTime;

public class StatusDTO {
	
	private String descricao;
	private String endereco;
	private Long numeroProdutos;
	private LocalDateTime dataHora;
	
	public StatusDTO() {
		super();
		this.dataHora = LocalDateTime.now();
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public Long getNumeroProdutos() {
		return numeroProdutos;
	}
	
	public void setNumeroProdutos(Long numeroProdutos) {
		this.numeroProdutos = numeroProdutos;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

}
