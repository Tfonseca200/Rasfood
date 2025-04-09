package br.com.rasmo.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ordens_cardapio")
public class OrdensCardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ordem ordem;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cardapio cardapio;

    @Column(name = "valor_registro")
    private BigDecimal valorRegistro;

    private Integer quantidade;

    public OrdensCardapio(Cardapio cardapio, Integer quantidade){
        this.cardapio = cardapio;
        this.quantidade = quantidade;
    }

    public OrdensCardapio(Cardapio cardapio, BigDecimal valorRegistro,  Integer quantidade) {
        this.ordem = ordem;
        this.cardapio = cardapio;
        this.valorRegistro = valorRegistro;
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public BigDecimal getValorRegistro() {
        return valorRegistro;
    }

    public void setValorRegistro(BigDecimal valorRegistro) {
        this.valorRegistro = valorRegistro;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }


    @Override
    public String toString() {
        return "OrdensCardapio{" +
                "id=" + id +
                ", cardapio=" + cardapio +
                ", valorRegistro=" + valorRegistro +
                ", quantidade=" + quantidade +
                '}';
    }
}
