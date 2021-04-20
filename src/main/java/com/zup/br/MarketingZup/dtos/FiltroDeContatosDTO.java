package com.zup.br.MarketingZup.dtos;

import com.zup.br.MarketingZup.model.Produto;

import java.util.List;

public class FiltroDeContatosDTO {

    private List<Produto> produtos;

    public FiltroDeContatosDTO() {
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
