package br.gov.school.projetos3.post.Enum;

import java.io.Serializable;

public enum EnumNecessidades implements Serializable{
	HIGIENE(1, "Higiene"),
	ALIMENTO(2, "Alimento"),
	MATERIAL_DE_CONSTRUCAO(3, "Material de Construção"),
	MEDICAMENTO(4, "Medicamento"),
	VESTIMENTAS(5, "Vestimentas"),
	MATERIAL_ESCOLAR(6, "Material Escolar"),
	MATERIAIS_ASSISTIVOS(7, "Materiais Assistivos"),
	MATERIAL_DE_LIMPEZA(8, "Material de Limpeza");
    
    private int codigo;
    private String descricao;
    
    private EnumNecessidades(int codigo, String descricao) {
        this.codigo=codigo;
        this.descricao=descricao;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getDescricao() {
        return descricao;
    }
    
    public static EnumNecessidades obterPorCodigo(int codigo) {
        for(EnumNecessidades necessidade : EnumNecessidades.values()) {
            if(necessidade.getCodigo()==codigo) {
                return necessidade;
            }
        }
        return null;
    }
}