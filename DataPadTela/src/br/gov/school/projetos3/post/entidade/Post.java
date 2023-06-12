package br.gov.school.projetos3.post.entidade;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.gov.school.projetos3.post.Enum.EnumNecessidades;

@SuppressWarnings("serial")
public class Post implements Serializable{
	private static final long serialVersionUID = 2210250118L;
	private LocalDateTime dataCriacao;
	private EnumNecessidades Necessidade;
	private String Descricao;
	
	public Post(LocalDateTime dataCriacao, EnumNecessidades Necessidade,  String Descricao) {
		this.dataCriacao = dataCriacao;
		this.Necessidade = Necessidade;
		this.Descricao = Descricao;
	}
	public EnumNecessidades getNecessidade() {
		return Necessidade;
	}
	public String getDescricao() {
		return Descricao;
	}
	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}
} 