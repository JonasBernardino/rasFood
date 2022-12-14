package br.com.rasmoo.restaurante.entity;

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
    private String descricao;
    private Boolean disponivel;
    private BigDecimal valor;
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;

    @Column(name = "data_de_registro")
    private LocalDateTime dataRegistro = LocalDateTime.now();

    public Cardapio() {
    }

    public Cardapio(String nome, String descricao, Boolean disponivel, BigDecimal valor, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.disponivel = disponivel;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
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
                ", descricao='" + descricao + '\'' +
                ", disponivel=" + disponivel +
                ", valor=" + valor +
                ", categoria=" + categoria +
                ", dataRegistro=" + dataRegistro +
                '}';
    }
}
