package com.zup.br.MarketingZup.repositories;

import com.zup.br.MarketingZup.model.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto,String> {
}
