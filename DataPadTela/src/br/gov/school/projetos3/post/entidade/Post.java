package br.gov.school.projetos3.post.entidade;

import java.time.LocalDateTime;

import br.gov.school.projetos3.post.Enum.EnumNecessidades;
import br.gov.school.projetos3.usuario.entidade.Identificavel;

public class Post extends Identificavel{
	private int idPost;
	private LocalDateTime dataCriacao;
	private EnumNecessidades Necessidade;
	private String Descricao;
	
	public Post(int idPost, LocalDateTime dataCriacao, EnumNecessidades Necessidade,  String Descricao) {
		this.idPost = idPost;
		this.dataCriacao = dataCriacao;
		this.Necessidade = Necessidade;
		this.Descricao = Descricao;
	}
	public int getIdPost() {
		return idPost;
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
	@Override
	public String obterChave() {
		return (idPost+"");
	}
} 