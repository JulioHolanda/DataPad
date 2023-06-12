package br.gov.school.projetos3.usuario.entidade;

import java.io.Serializable;

public abstract class Identificavel implements Serializable {
	private static final long serialVersionUID = 2210250118L;
	public abstract String obterChave();
}
