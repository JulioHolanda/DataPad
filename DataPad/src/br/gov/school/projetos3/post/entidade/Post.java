package br.gov.school.projetos3.post.entidade;

import br.gov.school.projetos3.post.Enum.EnumNecessidades;

public class Post {
	private int id;
	private EnumNecessidades Necessidade;
	private String Descricao;
	
	public Post(int id, EnumNecessidades Necessidade,  String Descricao) {
		this.id=id;
		this.Necessidade=Necessidade;
		this.Descricao=Descricao;
	}
	public int getid() {
		return id;
	}
	public EnumNecessidades getNecessidade() {
		return Necessidade;
	}
	public String getDescricao() {
		return Descricao;
	}
} 