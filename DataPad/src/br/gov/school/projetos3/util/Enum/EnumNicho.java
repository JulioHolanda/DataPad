package br.gov.school.projetos3.util.Enum;

public enum EnumNicho {
	CRIANCAS(1, "Crianças"),
    JOVENS(2, "Jovens"),
    ADULTOS(3, "Adultos"),
    ANIMAIS(4, "Animais"),
    FAMILIAS(5, "Famílias"),
    COMUNIDADES(6, "Comunidades"),
    IDOSOS(7, "Idosos"),
    PCD(8, "Pessoas com Deficiência"),
    DEPENDENTES_QUIMICOS(9, "Dependentes Químicos"),
    MULHERES(10, "Mulheres"),
    LGBTQIAP(11, "LGBTQIAP");

    private int codigo;
    private String descricao;

    private EnumNicho(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static EnumNicho obterPorCodigo(int codigo) {
        for (EnumNicho nicho : EnumNicho.values()) {
            if (nicho.getCodigo() == codigo) {
                return nicho;
            }
        }
        return null;
    }
}
