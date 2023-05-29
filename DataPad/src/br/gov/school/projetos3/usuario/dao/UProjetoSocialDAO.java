package br.gov.school.projetos3.usuario.dao;

import br.gov.school.projetos3.util.DAOGenerico;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;

public class UProjetoSocialDAO {
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "usuario" + FILE_SEP;

	private DAOGenerico daoEncapsulado;

	public UProjetoSocialDAO() {
		daoEncapsulado = new DAOGenerico(DIR_BASE);
	}

	public boolean incluir(UProjetoSocial uProjetoSocial) {
		return daoEncapsulado.incluir(uProjetoSocial);
	}

	public boolean alterar(UProjetoSocial uProjetoSocial) {
		 return daoEncapsulado.alterar(uProjetoSocial);
	}

	public UProjetoSocial buscar(String cadastroFisJur) {
		return (UProjetoSocial)daoEncapsulado.buscar(cadastroFisJur);
		
	}
}
