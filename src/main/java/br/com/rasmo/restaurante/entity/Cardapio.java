package br.com.rasmo.restaurante.entity;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cardapio")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String decricao;

    private boolean disponibilidade;

    private BigDecimal valor;

    @ManyToOne
    private Categoria categoria;

    @Column(name = "data_de_registro")
    private LocalDateTime dataRegistro = LocalDateTime.now();


    public Cardapio(String nome , String decricao, boolean disponibilidade, Categoria categoria) {
        this.nome = nome;
        this.decricao = decricao;
        this.disponibilidade = disponibilidade;
        this.categoria = categoria;
    }

    public Cardapio(String nome, String decricao, boolean disponibilidade, BigDecimal valor, Categoria categoria) {
        this.nome = nome;
        this.decricao = decricao;
        this.disponibilidade = disponibilidade;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDecricao() {
        return decricao;
    }

    public void setDecricao(String decricao) {
        this.decricao = decricao;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Cardapio{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", decricao='" + decricao + '\'' +
                ", disponibilidade=" + disponibilidade +
                ", valor=" + valor +
                ", categoria=" + categoria +
                ", dataRegistro=" + dataRegistro +
                '}';
    }
}


