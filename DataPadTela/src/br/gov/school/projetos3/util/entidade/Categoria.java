package br.gov.school.projetos3.util.entidade;

import br.gov.school.projetos3.util.Enum.*;

public class Categoria {
    private EnumCateg categoria;
    private EnumNicho nicho;

    public EnumCateg getCategoria() {
        return categoria;
    }
    public void setCategoria(EnumCateg categoria) {
        this.categoria = categoria;
    }
    public EnumNicho getNicho() {
        return nicho;
    }
    public void setNicho(EnumNicho nicho) {
        this.nicho = nicho;
    }

    
}
