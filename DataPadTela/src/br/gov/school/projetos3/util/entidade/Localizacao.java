package br.gov.school.projetos3.util.entidade;

import java.io.Serializable;

public class Localizacao implements Serializable{
    private String numero;
    private String complemento;
    private String rua;
    private String estadoProv;
    private String pais;

    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public String getEstadoProv() {
        return estadoProv;
    }
    public void setEstadoProv(String estadoProv) {
        this.estadoProv = estadoProv;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }

}