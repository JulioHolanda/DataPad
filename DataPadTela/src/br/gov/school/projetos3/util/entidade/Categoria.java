package br.gov.school.projetos3.util.entidade;

import java.io.Serializable;

import br.gov.school.projetos3.util.Enum.*;

@SuppressWarnings("serial")
public class Categoria implements Serializable{
    private EnumCategoria categoria;
    private EnumNicho nicho;

    public EnumCategoria getCategoria() {
        return categoria;
    }
    public void setCategoria(EnumCategoria categoria) {
        this.categoria = categoria;
    }
    public EnumNicho getNicho() {
        return nicho;
    }
    public void setNicho(EnumNicho nicho) {
        this.nicho = nicho;
    }

    
}
