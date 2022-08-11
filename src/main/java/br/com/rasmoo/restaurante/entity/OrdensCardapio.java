package br.com.rasmoo.restaurante.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ordens_cardapio")
public class OrdensCardapio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Ordem ordem;

    @ManyToOne
    private Cardapio cardapio;

    private BigDecimal valor;

    private Integer quantidade;

    public OrdensCardapio() {
    }

    public OrdensCardapio(Cardapio cardapio, Integer quantidade) {
        this.cardapio = cardapio;
        this.quantidade = quantidade;
        this.valor = cardapio.getValor();
    }

    public Integer getId() {
        return id;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public Cardapio getCardapio() {
        return cardapio;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }

    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "OrdensCardapio{" +
                "id=" + id +
                ", cardapio=" + cardapio +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }
}
