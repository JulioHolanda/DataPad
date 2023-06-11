package br.gov.school.projetos3.relatorio.entidade;

import java.util.ArrayList;
import br.gov.school.projetos3.relatorio.negocio.RelatorioMediator;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;

public class RelatorioList {
	private ArrayList<Relatorio> relatorios;
    private RelatorioMediator relatorioMediator;
    
    public RelatorioList() {
        this.relatorios = new ArrayList<>();
    }
    
    public void addRelatorio(UProjetoSocial projetoSocial, Relatorio relatorio) {
	    this.relatorios.add(relatorio);
	    relatorioMediator.incluir(projetoSocial, relatorio);
    }
        
    public Relatorio getLastRelatorio(){
    	Relatorio ultimo = relatorios.get(relatorios.size()-1);
    	return ultimo;
    }
    
    public ArrayList<Relatorio> getTodosRelatorios(){
    	return relatorios;
    }
}
