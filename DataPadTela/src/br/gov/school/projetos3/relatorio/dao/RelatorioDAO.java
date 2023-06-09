package br.gov.school.projetos3.relatorio.dao;

import br.gov.school.projetos3.geral.dao.DAOGenerico;
import br.gov.school.projetos3.relatorio.entidade.Relatorio;
import br.gov.school.projetos3.usuario.entidade.Identificavel;

public class RelatorioDAO {

	private static final String FILE_SEP;
    private static final String DIR_BASE;
    private DAOGenerico daoEncapsulado;
    
    static {
        FILE_SEP = System.getProperty("file.separator");
        DIR_BASE = "." + RelatorioDAO.FILE_SEP + "projetos3" + RelatorioDAO.FILE_SEP + "relatorio" + RelatorioDAO.FILE_SEP;
    }
    
    public RelatorioDAO() {
        this.daoEncapsulado = new DAOGenerico(RelatorioDAO.DIR_BASE);
    }
    
    public boolean incluir(final Relatorio relatorio) {
        return this.daoEncapsulado.incluir((Identificavel)relatorio);
    }
    
    public boolean alterar(final Relatorio relatorio) {
        return this.daoEncapsulado.alterar((Identificavel)relatorio);
    }
    
    public Relatorio buscar(final String chave) {
        return (Relatorio)this.daoEncapsulado.buscar(chave);
    }

  //metodo para deletar seria necessario?
    
	public Relatorio[] buscarTodos() {
		Identificavel[] identificaveis = daoEncapsulado.buscarTodos();
		if(identificaveis == null) {
			return new Relatorio[0];
		}
		
		Relatorio[] relatorios = new Relatorio[identificaveis.length];
		
		int contRelatorios = 0;
		
		for(Identificavel ident:identificaveis) {
			
			Object objeto = (Object) ident;
			
			if(objeto instanceof Relatorio) {
				relatorios[contRelatorios] = (Relatorio) ident;
				
				contRelatorios++;
			}
		}
		
		if(contRelatorios == 0) {
			return new Relatorio[0];
		}
		return relatorios;
		
	}

}
