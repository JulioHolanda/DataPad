package br.gov.school.projetos3.util.Enum;

import java.io.Serializable;

public enum EnumCategoria implements Serializable{
    EDUCACAO(1,"Educação"),
    SAUDE(2,"Saude"),
    RECURSOS_BASICOS(3,"Recursos Basicos"),
    ACOLHIMENTO(4,"Acolhimento"),
    NATUREZA(5,"Natureza"),
    ARTE(6,"Arte");
    
    private int codigo;
    private String descricao;
    private static final long serialVersionUID = 2210250118L;
    
    private EnumCategoria(int codigo, String descricao) {
        this.codigo=codigo;
        this.descricao=descricao;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    
    public static EnumCategoria obterPorCodigo(int codigo) {
        for(EnumCategoria categoria : EnumCategoria.values()) {
            if(categoria.getCodigo()==codigo) {
                return categoria;
            }
        }
        return null;
    }
}
