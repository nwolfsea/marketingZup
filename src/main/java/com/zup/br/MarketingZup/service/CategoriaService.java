package com.zup.br.MarketingZup.service;

import com.zup.br.MarketingZup.model.Categoria;
import com.zup.br.MarketingZup.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvarCategoria(Categoria categoria){
        try{
            Categoria obj = categoriaRepository.save(categoria);
            return categoria;
        }catch (Exception error){
            throw new RuntimeException("Categoria já cadastrada!");
        }
    }

    public List<Categoria> retornarTodasAsCategorias(){
        List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAll();
        return categorias;
    }

    public Categoria buscarCategoriaPeloId(String id){
        Optional<Categoria> optionalCategoria = categoriaRepository.findById(id);

        if(optionalCategoria.isPresent()){
            return optionalCategoria.get();
        }

        throw new RuntimeException("Categoria não existente!");
    }

    public Categoria atualizarCategoria(Categoria categoria){
        if (categoriaRepository.existsById(categoria.getNome())){
            Categoria objCategoria = salvarCategoria(categoria);
            return objCategoria;
        }
        throw new RuntimeException("Categoria não existente!");
    }

    public void deletarCategoria(String nome){
        categoriaRepository.deleteById(nome);
    }
}
