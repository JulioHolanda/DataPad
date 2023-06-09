package br.gov.school.projetos3.usuario.negocio;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import br.gov.school.projetos3.geral.util.StringUtil;
import br.gov.school.projetos3.usuario.dao.UProjetoSocialDAO;
import br.gov.school.projetos3.usuario.entidade.UProjetoSocial;

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
	
	public UProjetoSocial[] consultarUProjetosSociaisOrdemAleatoria() {
		UProjetoSocial[] projetosSociais = repositorioUProjSocial.buscarTodos();

		List<UProjetoSocial> projetosSociaisList = Arrays.asList(projetosSociais);

		Collections.shuffle(projetosSociaisList);

		projetosSociaisList.toArray(projetosSociais);
		return projetosSociais;
		
	}
	
    private String gerarIdDeCnpj(String cnpj) {
        // Remover caracteres não numéricos do CNPJ
        String cleanedCnpj = cnpj.replaceAll("[^0-9]", "");

        // Gerar um ID baseado no CNPJ usando UUID
        UUID uuid = UUID.nameUUIDFromBytes(cleanedCnpj.getBytes());
        return uuid.toString();
    }
    
	/*
	private String validar(UProjetoSocial cliente) {
	    if(ValidadorCPF.ehCpfValido(cliente.getCpf()) == false){
	        return "CPF Inv�lido";
	    }

	    else if (StringUtil.ehNuloOuBranco(cliente.getNomeCompleto())){
	        return "Nome Inv�lido";
	    }

	    else if (cliente.getSexo() == null) {
	        return "Sexo Inv�lido";
	    }

	    else if (cliente.obterIdade() < 18) {
	        return "A idade deve ser maior ou igual a 18.";
	    }

	    else if (cliente.getRenda() < 0) {
	        return "Renda Inv�lida";
	    }

	    else if (cliente.getEndereco() == null) {
	        return "Endere�o Inv�lido";
	    }

	    else if (StringUtil.ehNuloOuBranco(cliente.getEndereco().getLogradouro()) || cliente.getEndereco().getLogradouro().length() < 4) {
	        return "Logradouro Inv�lido"; 
	    }

	    else if (cliente.getEndereco().getNumero() < 0) {
	        return "Numero de endere�o inv�lido";
	    }

	    else if (StringUtil.ehNuloOuBranco(cliente.getEndereco().getCidade())){
	        return "Cidade Inv�lida"; 
	    }
	    
	    else if (StringUtil.ehNuloOuBranco(cliente.getEndereco().getEstado())) {
	        return "Estado Inv�lida"; 
	    }

	    else if (StringUtil.ehNuloOuBranco(cliente.getEndereco().getPais())) {
	        return "Pais Inv�lido"; 
	    }
	    return null;
    }
	 * */

}
