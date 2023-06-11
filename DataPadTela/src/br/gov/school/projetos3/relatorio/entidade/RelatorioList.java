package br.gov.school.projetos3.relatorio.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import br.gov.school.projetos3.relatorio.negocio.RelatorioMediator;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;

@SuppressWarnings("serial")
public class RelatorioList implements Serializable{
	private ArrayList<Relatorio> relatorios;
    
    public RelatorioList() {
        this.relatorios = new ArrayList<Relatorio>();
    }
    
    public void addRelatorio(UProjetoSocial projetoSocial, Relatorio relatorio) {
	    this.relatorios.add(relatorio);
	    RelatorioMediator relatorioMediator = RelatorioMediator.getInstance();
	    relatorioMediator.incluir(projetoSocial, relatorio);
    }
        
    public Relatorio getLastRelatorio(){
    	Relatorio ultimo = relatorios.get(relatorios.size()-1);
    	return ultimo;
    }
    
    public ArrayList<Relatorio> getTodosRelatorios(){
    	return relatorios;
    }
    
    public boolean isEmpty() {
    	return relatorios.isEmpty();
    }
}
