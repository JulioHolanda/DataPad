package br.gov.school.projetos3.relatorio.entidade;

import java.io.Serializable;
import java.time.LocalDateTime;


@SuppressWarnings("serial")
public class Relatorio implements Serializable{
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
