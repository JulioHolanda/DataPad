package br.gov.school.projetos3.usuario.entidade;

public abstract class Usuario extends Identificavel {
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "usuario" + FILE_SEP;
	private static final String EXT = ".dat";
	
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
	
	@Override
	public String obterChave() {
		String nomeArq = DIR_BASE + id + EXT;
		return nomeArq;
	}
}
