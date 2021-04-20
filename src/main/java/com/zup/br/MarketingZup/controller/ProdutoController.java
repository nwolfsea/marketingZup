package com.zup.br.MarketingZup.controller;

import com.zup.br.MarketingZup.model.Produto;
import com.zup.br.MarketingZup.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto registrarProduto(@RequestBody Produto produto){
        return produtoService.salvarProduto(produto);
    }

    @GetMapping
    public List<Produto> listarProduto(){
        return produtoService.retornarTodosOsProdutos();
    }

    @GetMapping("{id}/")
    public Produto buscarProdutoPeloId(@PathVariable String id){
        return produtoService.buscarProdutoPeloId(id);
    }

    @PutMapping("{id}/")
    public Produto atualizarProduto(@PathVariable String id, Produto produto){
        return produtoService.atualizarProduto(produto);
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarProduto(@PathVariable String id){
        produtoService.deletarProduto(id);
    }

}
