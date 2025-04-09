package br.com.rasmo.restaurante.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enderecos")
public class Enderecos {

    @Id
    private String cep;

    private String complemento;

    private String rua;

    private String cidade;

    public Enderecos(String cep, String complemento, String rua, String cidade) {
        this.cep = cep;
        this.complemento = complemento;
        this.rua = rua;
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
