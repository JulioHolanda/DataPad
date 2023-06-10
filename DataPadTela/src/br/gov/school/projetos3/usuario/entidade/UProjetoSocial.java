package br.gov.school.projetos3.usuario.entidade;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.gov.school.projetos3.post.entidade.PostList;
import br.gov.school.projetos3.util.entidade.*;

public class UProjetoSocial extends Usuario {
	private Localizacao cep;
	private String nomeFantasia;
	private Categoria categoria;
	private String descricao;
	private PostList posts;
	private Contato contato;

	public UProjetoSocial(String idUser, String senha, String nome, Localizacao cep, String nomeFantasia, String cadastroFisJur, Categoria categoria, Contato contato, String descricao) {
		super(idUser, senha , nome, cadastroFisJur);
		// como faria pra gerar o id??? mediador? ou 'this' na funcao abaixo?
		this.cep = cep;
		this.nomeFantasia = nomeFantasia;
		this.categoria = categoria;
		this.contato = contato;
		this.descricao = descricao;
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
	public PostList getPosts() {
		return posts;
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


	@Override
	public String obterChave() {
		return (this.getIdUser()+"");
	}

}
