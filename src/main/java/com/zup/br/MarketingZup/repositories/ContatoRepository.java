package com.zup.br.MarketingZup.repositories;

import com.zup.br.MarketingZup.model.Contato;
import com.zup.br.MarketingZup.model.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ContatoRepository extends CrudRepository<Contato, String> {

    List<Contato>findAllByProdutosNome(String nome);
}
