package br.gov.school.projetos3.util;

import br.gov.school.projetos3.geral.util.StringUtil;
import br.gov.school.projetos3.util.entidade.Localizacao;

public class Validador {

	public static boolean ehCepValido(Localizacao cep){

		if(StringUtil.ehNuloOuBranco(cep.getNumero())){
	        return false;
	    }

		else if (StringUtil.ehNuloOuBranco(cep.getRua())){
			return false;
	    }

	    else if (StringUtil.ehNuloOuBranco(cep.getEstadoProv())) {
	    	return false;
	    }

	    else if (StringUtil.ehNuloOuBranco(cep.getPais())) {
	    	return false;
	    }
	
		return true;
	}

	
	public static boolean ehCnpjValido(String cadastroFisJur) {
		
		if (StringUtil.ehNuloOuBranco(cadastroFisJur)) {
        	return false;
	    }
		if (cadastroFisJur.length() == 11) {
			String cpf = cadastroFisJur; 

		    for (int i = 0; i < cpf.length(); i++) {
		        char c = cpf.charAt(i);
		        if (!Character.isDigit(c)) {
		        	return false;
		        }
		    }
		    int[] numeros = new int[11];
	        for (int i = 0; i < 11; i++) {
	            numeros[i] = Character.getNumericValue(cpf.charAt(i));
	        }
	        int soma = 0;
	        for (int i = 0; i < 9; i++) {
	            soma += numeros[i] * (10 - i);
	        }
	        int resto = soma % 11;
	        int dv1 = resto < 2 ? 0 : 11 - resto;

	        if (numeros[9] != dv1) {
	            return false;
	        }
	        soma = 0;
	        for (int i = 0; i < 10; i++) {
	            soma += numeros[i] * (11 - i);
	        }
	        resto = soma % 11;
	        int dv2 = resto < 2 ? 0 : 11 - resto;
	        if (numeros[10] != dv2) {
	            return false;
	        }        
	        int cont = 0;
	        //verifica cpf com todos ou praticamente todos com numeros iguais
	        for (int i = 1; i < cpf.length(); i++) {
	            if (cpf.charAt(i) == cpf.charAt(0)) {
	            	cont++;
	            }
	        } 
	        if (cont >= 10) {
	        	return false;
	        }
		    return true;
		    
		}else if(cadastroFisJur.length() == 14) {
			String cnpj = cadastroFisJur;
		    
	        cnpj = cnpj.replaceAll("[^0-9]", "");

	        if (cnpj.length() != 14)
	            return false;

	        int[] digits = new int[14];
	        for (int i = 0; i < 14; i++) {
	            digits[i] = Character.getNumericValue(cnpj.charAt(i));
	        }

	        boolean todosDigitosIguais = true;
	        for (int i = 1; i < 14; i++) {
	            if (digits[i] != digits[0]) {
	                todosDigitosIguais = false;
	                break;
	            }
	        }
	        if (todosDigitosIguais)
	            return false;

	        int soma = 0;
	        int peso = 5;
	        for (int i = 0; i < 12; i++) {
	            soma += digits[i] * peso;
	            peso--;
	            if (peso < 2)
	                peso = 9;
	        }
	        int resto = soma % 11;
	        int primeiroDigitoVerificador = (resto < 2) ? 0 : (11 - resto);
	        if (digits[12] != primeiroDigitoVerificador)
	            return false;

	        soma = 0;
	        peso = 6;
	        for (int i = 0; i < 13; i++) {
	            soma += digits[i] * peso;
	            peso--;
	            if (peso < 2)
	                peso = 9;
	        }
	        resto = soma % 11;
	        int segundoDigitoVerificador = (resto < 2) ? 0 : (11 - resto);
	        if (digits[13] != segundoDigitoVerificador)
	            return false;

	        return true;
	    }
		
		return false;
	}
	
}
