package br.gov.school.projetos3.geral.util;

public class StringUtil {
    private StringUtil() {}

    public static boolean ehNuloOuBranco(String str){
        return str == null || str.trim().isEmpty();
    }

}
