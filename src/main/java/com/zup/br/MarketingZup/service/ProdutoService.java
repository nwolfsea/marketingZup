package com.zup.br.MarketingZup.service;


import com.zup.br.MarketingZup.model.Produto;
import com.zup.br.MarketingZup.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto){
        try{
           Produto obj = produtoRepository.save(produto);
            return produto;
        }catch (Exception error){
            throw new RuntimeException("Produto já cadastrado!");
        }
    }

    public List<Produto> retornarTodosOsProdutos(){
        List<Produto> produtos = (List<Produto>) produtoRepository.findAll();
        return produtos;
    }

    public Produto buscarProdutoPeloId(String id){
        Optional<Produto> optionalProduto = produtoRepository.findById(id);

        if(optionalProduto.isPresent()){
            return optionalProduto.get();
        }

        throw new RuntimeException("Produto não existente!");
    }

    public Produto atualizarProduto(Produto produto){
        if (produtoRepository.existsById(produto.getNome())){
           Produto objProduto = salvarProduto(produto);
            return objProduto;
        }
        throw new RuntimeException("Produto não existente!");
    }

    public void deletarProduto(String nome){
        produtoRepository.deleteById(nome);
    }
}


