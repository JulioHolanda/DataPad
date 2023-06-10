package br.gov.school.projetos3.usuario.entidade;

public abstract class Usuario extends Identificavel {
	
	private long idUser;
	private String nome;
	private String cadastroFisJur;
	private String senha;
	
	public Usuario(long idUser, String senha, String nome, String cadastroFisJur) {
		this.idUser = idUser;
		this.nome = nome;
		this.cadastroFisJur = cadastroFisJur;
		this.senha = senha;
	}
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public long getIdUser() {
		return idUser;
	}


	public String getCadastroFisJur() {
		return cadastroFisJur;
	}
	
}