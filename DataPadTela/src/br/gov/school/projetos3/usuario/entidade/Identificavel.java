package br.gov.school.projetos3.usuario.entidade;

import java.io.Serializable;

@SuppressWarnings("serial")
public abstract class Identificavel implements Serializable {
	
	public abstract String obterChave();
}
