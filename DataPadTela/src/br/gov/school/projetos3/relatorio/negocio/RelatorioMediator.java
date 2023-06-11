package br.gov.school.projetos3.relatorio.negocio;

import br.gov.school.projetos3.geral.util.StringUtil;
import br.gov.school.projetos3.relatorio.entidade.Relatorio;
import br.gov.school.projetos3.relatorio.negocio.RelatorioMediator;
import br.gov.school.projetos3.usuario.dao.UProjetoSocialDAO;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;


public class RelatorioMediator {
	
	private static RelatorioMediator instance;
	public UProjetoSocialDAO repositorioRelatorio;
	
	private RelatorioMediator() {
		repositorioRelatorio = new UProjetoSocialDAO();
	}
	
	public static RelatorioMediator getInstance() {
		if(instance == null) {
			instance = new RelatorioMediator();
		}
		return instance;
	}
    
	public String incluir(UProjetoSocial projetoSocial,Relatorio relatorio) {
		String msg = validar(relatorio); 
        if (msg == null){
        	msg = "relatorio registrado com Sucesso";
            boolean res = repositorioRelatorio.alterar(projetoSocial);
            if (!res) {
            	msg = "Erro ao incluir relatorio no repositorio";
            }
        } 
        return msg;
    }

	private String validar(Relatorio relatorio) {
		
		if (StringUtil.ehNuloOuBranco(relatorio.getDescricao())){
	        return "Relatorio Invalida";
	    }

	    return null;
    }

}
