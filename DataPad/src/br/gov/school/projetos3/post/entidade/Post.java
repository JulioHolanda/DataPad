package br.gov.school.projetos3.post.entidade;

import br.gov.school.projetos3.post.Enum.EnumNecessidades;
import br.gov.school.projetos3.usuario.entidade.Identificavel;

public class Post extends Identificavel{
	private int idPost;
	private EnumNecessidades Necessidade;
	private String Descricao;
	
	public Post(int idPost, EnumNecessidades Necessidade,  String Descricao) {
		this.idPost=idPost;
		this.Necessidade=Necessidade;
		this.Descricao=Descricao;
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
	@Override
	public String obterChave() {
		return (idPost+"");
	}
} 