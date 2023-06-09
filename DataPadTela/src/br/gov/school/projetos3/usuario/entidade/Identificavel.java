package br.gov.school.projetos3.usuario.entidade;

import java.io.Serializable;

public abstract class Identificavel implements Serializable {
	
	public abstract String obterChave();
}
