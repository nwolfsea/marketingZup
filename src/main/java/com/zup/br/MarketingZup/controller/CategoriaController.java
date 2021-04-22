package com.zup.br.MarketingZup.controller;

import com.zup.br.MarketingZup.model.Categoria;
import com.zup.br.MarketingZup.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("categorias/")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria registrarCategoria(@RequestBody Categoria categoria){
        return categoriaService.salvarCategoria(categoria);
    }

    @GetMapping("listar/categorias/}/")
    public List<Categoria> listarCategorias(){
        return categoriaService.retornarTodasAsCategorias();
    }

    @GetMapping("{id}/")
    public Categoria buscarCategoriaPeloId(@PathVariable String id){
        return categoriaService.buscarCategoriaPeloId(id);
    }

    @PutMapping("{id}/")
    public Categoria atualizarCategoria(@PathVariable String id, Categoria categoria){
        return categoriaService.atualizarCategoria(categoria);
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCategoria(@PathVariable String id){
        categoriaService.deletarCategoria(id);
    }

}
