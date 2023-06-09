package br.gov.school.projetos3.relatorio.negocio;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import br.gov.school.projetos3.geral.util.StringUtil;
import br.gov.school.projetos3.relatorio.dao.RelatorioDAO;
import br.gov.school.projetos3.relatorio.entidade.Relatorio;
import br.gov.school.projetos3.relatorio.negocio.RelatorioMediator;
import br.gov.school.projetos3.usuario.entidade.Relatorio;

public class RelatorioMediator {
	
	private static RelatorioMediator instance;
	public RelatorioDAO repositorioRelatorio;
	
	private RelatorioMediator() {
		repositorioRelatorio = new RelatorioDAO();
	}
	
	public static RelatorioMediator getInstance() {
		if(instance == null) {
			instance = new RelatorioMediator();
		}
		return instance;
	}
    
	public static String generateId(LocalDateTime dateTime, String idUser) {
        String formattedDateTime = dateTime.toString().replace(":", "");
        return "2_" + formattedDateTime + "_" + idUser;
    }
	
	public String incluir(Relatorio relatorio) {
		String msg = validar(relatorio); 
        if (msg == null){
        	msg = "relatorio registrado com Sucesso";
            boolean res = repositorioRelatorio.incluir(relatorio);
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
	

	public Relatorio[] coletarRelatorios() {
		Relatorio[] relatorios = repositorioRelatorio.buscarTodos();

		return relatorios;
	}
	

}
