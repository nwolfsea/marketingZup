package com.zup.br.MarketingZup.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "contatos")
public class Contato {
    @Column(name = "nome_completo")
    private String nomeCompleto;
    @Id
    private String email;
    @Column(name = "telefone_contato")
    private String telefone;

    @ManyToMany
    private List<Produto> produtos;


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

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }


}
