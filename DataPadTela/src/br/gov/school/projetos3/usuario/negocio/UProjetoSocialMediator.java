package br.gov.school.projetos3.usuario.negocio;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import br.gov.school.projetos3.geral.util.StringUtil;
import br.gov.school.projetos3.usuario.dao.UProjetoSocialDAO;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;
import br.gov.school.projetos3.util.Validador;

public class UProjetoSocialMediator {
	private static UProjetoSocialMediator instance;
	public UProjetoSocialDAO repositorioUProjSocial;
	
	private UProjetoSocialMediator() {
		repositorioUProjSocial = new UProjetoSocialDAO();
	}
	
	public static UProjetoSocialMediator getInstance() {
		if(instance == null) {
			instance = new UProjetoSocialMediator();
		}
		return instance;
	}

	
    public String gerarIdDeCnpj(String cnpj) {
        // Remover caracteres não numéricos do CNPJ
        String cleanedCnpj = cnpj.replaceAll("[^0-9]", "");

        // Gerar um ID baseado no CNPJ usando UUID
        UUID uuid = UUID.nameUUIDFromBytes(cleanedCnpj.getBytes());
        return uuid.toString();
    }
    
	public String incluir(UProjetoSocial uProjetoSocial) {
		String msg = validar(uProjetoSocial); 
        if (msg == null){
        	msg = "Projeto Social registrado com Sucesso";
            boolean res = repositorioUProjSocial.incluir(uProjetoSocial);
            if (!res) {
            	msg = "Erro ao incluir Projeto Social no reposit�rio";
            }
        } 
        return msg;
    }
	
    public String alterar(UProjetoSocial uProjetoSocial) {
    	String msgErro = validar(uProjetoSocial); 
        if (msgErro == null){
            boolean res = repositorioUProjSocial.alterar(uProjetoSocial);
            if (!res) {
            	msgErro = "Erro ao alterar Projeto Social no repositorio";
            }
        }
        return msgErro;
    }

	
	private String validar(UProjetoSocial uProjetoSocial) {

		if(Validador.ehCepValido(uProjetoSocial.getCep()) == false){
	        return "CEP Invalido";
	    }

		else if (StringUtil.ehNuloOuBranco(uProjetoSocial.getNomeFantasia())){
	        return "Nome Invalido";
	    }

	    else if (uProjetoSocial.getCategoria() == null) {
	        return "Categoria Invalida";
	    }

	    else if (uProjetoSocial.getDescricao() == null) {
	        return "descricao Invalida";
	    }

	    else if (uProjetoSocial.getContato() == null) {
	        return "Contato Invalido";
	    }

	    else if(Validador.ehCnpjValido(uProjetoSocial.getCadastroFisJur()) == false){
	        return "Cadastro Invalido";
	    }

	    else if (uProjetoSocial.getNome() == null) {
	        return "Numero de endere�o inv�lido";
	    }

	    return null;
    }
	
	
	public UProjetoSocial[] consultarUProjetosSociaisOrdemAleatoria() {
		UProjetoSocial[] projetosSociais = repositorioUProjSocial.buscarTodos();

		List<UProjetoSocial> projetosSociaisList = Arrays.asList(projetosSociais);

		Collections.shuffle(projetosSociaisList);

		projetosSociaisList.toArray(projetosSociais);
		return projetosSociais;
		
	}
	
	public UProjetoSocial[] buscarTodos() {
		return repositorioUProjSocial.buscarTodos();
	}

}
