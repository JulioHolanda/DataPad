package br.gov.school.projetos3.relatorio.entidade;

import java.time.LocalDateTime;


public class Relatorio{
	private LocalDateTime dataCriacao;
	private String descricao;
	
	public Relatorio(LocalDateTime dataCriacao, String descricao) {
		this.dataCriacao = dataCriacao;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
}
