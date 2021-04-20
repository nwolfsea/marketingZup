package com.zup.br.MarketingZup.model;

import javax.persistence.*;

@Entity
@Table(name = "contatos")
public class Contato {
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String email;
    @Column(name = "telefone_contato")
    private String telefone;

    @OneToMany
    private Produto produto;

    public Contato() {
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
