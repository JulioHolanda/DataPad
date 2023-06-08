package br.gov.school.projetos3.usuario.dao;

import br.gov.school.projetos3.util.DAOGenerico;
import br.gov.school.projetos3.usuario.entidade.Identificavel;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;

public class UProjetoSocialDAO {
	private static final String FILE_SEP = System.getProperty("file.separator");
	private static final String DIR_BASE = "." + FILE_SEP + "projetos3"+ FILE_SEP + "usuario" + FILE_SEP;

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
	public UProjetoSocial[] buscarTodos() {
		Identificavel[] identificaveis = daoEncapsulado.buscarTodos();
		if(identificaveis == null) {
			return new UProjetoSocial[0];
		}
		
		UProjetoSocial[] clientes = new UProjetoSocial[identificaveis.length];
		
		int contClientes = 0;
		
		for(Identificavel ident:identificaveis) {
			
			Object objeto = (Object) ident;
			
			if(objeto instanceof UProjetoSocial) {
				clientes[contClientes] = (UProjetoSocial) ident;
				
				contClientes++;
			}
		}
		
		if(contClientes == 0) {
			return new UProjetoSocial[0];
		}
		return clientes;
		
	}
}
