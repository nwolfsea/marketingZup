package com.zup.br.MarketingZup.dtos;

import com.zup.br.MarketingZup.model.Produto;


public class FiltroDeContatosDTO {

    private Produto produto;

    public FiltroDeContatosDTO() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
