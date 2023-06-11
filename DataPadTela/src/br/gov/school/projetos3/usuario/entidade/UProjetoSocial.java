package br.gov.school.projetos3.usuario.entidade;

import java.util.ArrayList;

import br.gov.school.projetos3.post.entidade.Post;
import br.gov.school.projetos3.post.entidade.PostList;
import br.gov.school.projetos3.relatorio.entidade.Relatorio;
import br.gov.school.projetos3.util.entidade.*;

@SuppressWarnings("serial")
public class UProjetoSocial extends Usuario {
	private boolean isActive;
	private Localizacao cep;
	private String nomeFantasia;
	private Categoria categoria;
	private String descricao;
	private PostList posts;
	private Contato contato;
	private ArrayList<Relatorio> relatorios;

	public UProjetoSocial(String idUser, String senha, String nome, Localizacao cep, String nomeFantasia, String cadastroFisJur, Categoria categoria, Contato contato, String descricao) {
		super(idUser, senha , nome, cadastroFisJur);
		this.cep = cep;
		this.nomeFantasia = nomeFantasia;
		this.categoria = categoria;
		this.contato = contato;
		this.descricao = descricao;
		this.setActive(true);
	}


	public Localizacao getCep() {
		return cep;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public void setPost(Post post) {
		this.posts.addPost(this, post);
	}
	
	public ArrayList<Post> getPosts() {
		return posts.getAllPosts();
	}
	public Contato getContato() {
		return contato;
	}
	public void setCep(Localizacao cep) {
		this.cep = cep;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setPosts(PostList posts) {
		this.posts = posts;
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public ArrayList<Relatorio> getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(ArrayList<Relatorio> relatorios) {
		this.relatorios = relatorios;
	}

	@Override
	public String obterChave() {
		return (this.getIdUser()+"");
	}

}
