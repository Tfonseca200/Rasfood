package br.com.rasmo.restaurante.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Contato {

    private String ddd;
    private String telefone;

    public Contato(){

    }

    public Contato(String ddd, String telefone) {
        this.ddd = ddd;
        this.telefone = telefone;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "ddd='" + ddd + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
