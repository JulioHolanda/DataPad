package br.gov.school.projetos3.usuario.entidade;

import java.time.LocalDate;
import java.util.ArrayList;

import br.gov.school.projetos3.post.entidade.Post;
import br.gov.school.projetos3.post.entidade.PostList;
import br.gov.school.projetos3.relatorio.entidade.Relatorio;
import br.gov.school.projetos3.relatorio.entidade.RelatorioList;
import br.gov.school.projetos3.util.entidade.*;


public class UProjetoSocial extends Usuario {
	private static final long serialVersionUID = 2210250118L;
	private Localizacao cep;
	private String nomeFantasia;
	private Categoria categoria;
	private String descricao;
	private PostList posts;
	private Contato contato;
	private RelatorioList relatorios;

	private LocalDate dataAtualizacao;

	public UProjetoSocial(String idUser, String senha, String nome, Localizacao cep, String nomeFantasia, String cadastroFisJur, Categoria categoria, Contato contato, String descricao) {
		super(idUser, senha , nome, cadastroFisJur);
		this.cep = cep;
		this.nomeFantasia = nomeFantasia;
		this.categoria = categoria;
		this.contato = contato;
		this.descricao = descricao;
		this.posts = new PostList();
		this.relatorios = new RelatorioList();
		this.setDataAtualizacao(LocalDate.now());
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
	
	public Relatorio getRelatorio() {
		if(relatorios.isEmpty()) {
			return null;
		}
		return relatorios.getLastRelatorio();
	}
	
	public void setPost(Post post) {
		this.posts.addPost(this, post);
	}
	
	public ArrayList<Post> getPosts() {
		if(posts.isEmpty()) {
			return null;
		}
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
	public void setRelatorio(Relatorio relatorio) {
		this.setDataAtualizacao(LocalDate.now());			
		this.relatorios.addRelatorio(this, relatorio);	
	}
	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	public void setRelatorios(RelatorioList relatorios) {
		this.relatorios = relatorios;
	}
	public boolean isActive() {
		
		LocalDate umAnoAtras = LocalDate.now();
		umAnoAtras = umAnoAtras.minusYears(1L);
		if (this.getDataAtualizacao().isBefore(umAnoAtras)) {
			return false;
		}
		
		return true;
	}



	@Override
	public String obterChave() {
		return (this.getIdUser()+"");
	}

	public void setPostList(PostList postList) {
		this.posts = postList;
		
	}

	public LocalDate getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDate dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
