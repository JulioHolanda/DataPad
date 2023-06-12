package br.gov.school.projetos3.util.entidade;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Contato implements Serializable{
	private static final long serialVersionUID = 2210250118L;
	private String telefone;
	private String email;
	private String redeSocial1;
	private String redeSocial2;
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getRedeSocial1() {
		return redeSocial1;
	}
	
	public void setRedeSocial1(String redeSocial1) {
		this.redeSocial1 = redeSocial1;
	}
	
	public String getRedeSocial2() {
		return redeSocial2;
	}
	
	public void setRedeSocial2(String redeSocial2) {
		this.redeSocial2 = redeSocial2;
	}
}
