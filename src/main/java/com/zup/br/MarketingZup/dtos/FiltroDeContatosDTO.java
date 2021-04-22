package com.zup.br.MarketingZup.dtos;

import com.zup.br.MarketingZup.model.Categoria;
import com.zup.br.MarketingZup.model.Produto;


public class FiltroDeContatosDTO {

    private Produto produto;
    private Categoria categoria;

    public FiltroDeContatosDTO() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
