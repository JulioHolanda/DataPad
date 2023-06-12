package br.gov.school.projetos3.relatorio.entidade;

import java.io.Serializable;
import java.time.LocalDate;


@SuppressWarnings("serial")
public class Relatorio implements Serializable{
	private static final long serialVersionUID = 2210250118L;
	private LocalDate dataCriacao;
	private String descricao;
	
	public Relatorio(LocalDate dataCriacao, String descricao) {
		this.dataCriacao = dataCriacao;
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
}
