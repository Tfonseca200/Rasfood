package br.com.rasmo.restaurante.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    private String cpf;

    private String nome;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.PERSIST)
    private List<Endereco> enderecoList = new ArrayList<>();


    public Cliente() {
    }

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public void addEndereco(Endereco endereco){
        endereco.setCliente(this);
        this.enderecoList.add(endereco);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Endereco> getEndereco() {
        return enderecoList;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.enderecoList = endereco;
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco=" + enderecoList +
                '}';
    }
}
