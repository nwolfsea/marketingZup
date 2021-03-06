package com.zup.br.MarketingZup.repositories;

import com.zup.br.MarketingZup.model.Contato;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ContatoRepository extends CrudRepository<Contato, String> {

    List<Contato>findAllByProdutosNome(String nome);
    List<Contato>findAllByProdutosCategoriasNome(String nome);
    Contato findByEmail(String email);
}
