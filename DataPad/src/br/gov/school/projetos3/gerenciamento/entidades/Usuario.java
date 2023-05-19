package br.gov.school.projetos3.gerenciamento.entidades;

public abstract class Usuario {
	private long id;
	private String nome;
	public Usuario(String nome) {
		this.nome = nome;
	}
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public abstract long gerarId();
	
}
