package br.gov.school.projetos3.relatorio.entidade;

import java.io.Serializable;
import java.util.ArrayList;
import br.gov.school.projetos3.relatorio.negocio.RelatorioMediator;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;

@SuppressWarnings("serial")
public class RelatorioList implements Serializable{
	private static final long serialVersionUID = 2210250118L;
	private ArrayList<Relatorio> relatorios;
    
    public RelatorioList() {
        this.relatorios = new ArrayList<Relatorio>();
    }
    
    public boolean addRelatorio(UProjetoSocial projetoSocial, Relatorio relatorio) {
	    this.relatorios.add(relatorio);
	    projetoSocial.setRelatorios(this);
	    RelatorioMediator relatorioMediator = RelatorioMediator.getInstance();
	    if (relatorioMediator.incluir(projetoSocial, relatorio).compareTo("relatorio registrado com Sucesso")==0) {
	    	return true;
	    }
	    return false;
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
