package br.gov.school.projetos3.usuario.entidade;


public abstract class Usuario extends Identificavel {
	private static final long serialVersionUID = 2210250118L;
	private String idUser;
	private String nome;
	private String cadastroFisJur;
	private String senha;
	
	public Usuario(String idUser, String senha, String nome, String cadastroFisJur) {
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


	public String getIdUser() {
		return idUser;
	}
	
	public String getSenha(){
		return senha;
	}


	public String getCadastroFisJur() {
		return cadastroFisJur;
	}
	
}
