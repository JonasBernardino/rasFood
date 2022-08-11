package br.com.rasmoo.restaurante.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pratos")
public class Prato {
    @Id
    private Integer id;
    private String nome;
    private String descricao;
    private Boolean disponivel;
    private BigDecimal valor;
    private LocalDateTime dataRegistro = LocalDateTime.now();

    public Prato(Integer id) {
    }

    public Prato(Integer id, String nome, String descricao, Boolean disponivel, BigDecimal valor, LocalDateTime dataRegistro) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.disponivel = disponivel;
        this.valor = valor;
        this.dataRegistro = dataRegistro;
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

    @Override
    public String toString() {
        return "Prato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", disponivel=" + disponivel +
                ", valor=" + valor +
                ", dataRegistro=" + dataRegistro +
                '}';
    }
}
