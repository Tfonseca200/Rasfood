package br.com.rasmo.restaurante.entity;

import jdk.jfr.Name;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordens")
public class Ordem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "valor_total")
    private BigDecimal valorTotal =BigDecimal.ZERO;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    private Cliente cliente;

    /*
    @ManyToMany
    @JoinTable(
            name = "ordens_cardapio",
            joinColumns = @JoinColumn(name = "ordem_id"),
            inverseJoinColumns = @JoinColumn(name = "cardapio_id")
    )
     */
    @OneToMany(mappedBy = "ordem", cascade = CascadeType.ALL)
    private List<OrdensCardapio> ordensCardapiosList = new ArrayList<>();



    public Ordem() {
    }

    public Ordem(Cliente cliente) {
        this.cliente = cliente;

    }

    public void addOrdemCardapio (OrdensCardapio ordensCardapio){
        ordensCardapio.setOrdem(this);
        this.ordensCardapiosList.add(ordensCardapio);
        this.valorTotal = valorTotal.add(ordensCardapio.getValorRegistro().multiply(BigDecimal.valueOf(ordensCardapio.getQuantidade())));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<OrdensCardapio> getOrdensCardapiosList() {
        return ordensCardapiosList;
    }

    public void setOrdensCardapiosList(List<OrdensCardapio> ordensCardapiosList) {
        this.ordensCardapiosList = ordensCardapiosList;
    }

    @Override
    public String toString() {
        return "Ordem{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", dataCriacao=" + dataCriacao +
                ", cliente=" + cliente +
                ", ordensCardapiosList=" + ordensCardapiosList +
                '}';
    }
}

