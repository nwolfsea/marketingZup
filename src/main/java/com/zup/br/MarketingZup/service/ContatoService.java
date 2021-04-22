package com.zup.br.MarketingZup.service;

import com.zup.br.MarketingZup.dtos.FiltroDeContatosDTO;
import com.zup.br.MarketingZup.model.Contato;
import com.zup.br.MarketingZup.model.Produto;
import com.zup.br.MarketingZup.repositories.ContatoRepository;
import com.zup.br.MarketingZup.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public Contato salvarContato(Contato contato){
        try{

            //verificar se o contato existe na base
            //se existir, atualizar o contato buscado do banco com
            //o contato da requisição

            Contato contatoBD = contatoRepository.findByEmail(contato.getEmail());
            if(contatoBD != null){
                for (Produto produto : contatoBD.getProdutos()) {
                   if(!contato.getProdutos().contains(produto)){
                    contato.getProdutos().add(produto);
                }}
            }

            for (Produto produto : contato.getProdutos()) {
                Produto produtoBD = produtoRepository.findByNome(produto.getNome());
                if(produtoBD == null){
                    produtoRepository.save(produto);
                }


            }
            Contato obj = contatoRepository.save(contato);
            return obj;

        }catch (Exception error){
            throw new RuntimeException("Erro ao cadastrar contato!");
        }
    }

    public List<Contato> retornarTodosOsContatos(){
        List<Contato> contatos = (List<Contato>) contatoRepository.findAll();
        return contatos;
    }

    public Contato buscarContatoPeloId(String id){
        Optional<Contato> optionalContato = contatoRepository.findById(id);

        if(optionalContato.isPresent()){
            return optionalContato.get();
        }

        throw new RuntimeException("Contato não existente!");
    }

    public Contato atualizarContato(Contato contato){
        if (contatoRepository.existsById(contato.getEmail())){
            Contato objContato = salvarContato(contato);
            return objContato;
        }
        throw new RuntimeException("Contato não existente!");
    }

    public void deletarContato(String email){
        contatoRepository.deleteById(email);
    }


    public List<Contato> pesquisarTodosOsContatosPelosProdutos(FiltroDeContatosDTO filtro){
        if(filtro.getProduto() == null){
            return (List<Contato>) contatoRepository.findAll();
        }
        return contatoRepository.findAllByProdutosNome(filtro.getProduto().getNome());
    }

    public List<Contato> pesquisarTodosOsContatosPelasCategorias(FiltroDeContatosDTO filtro){
        if(filtro.getCategoria() == null){
            return (List<Contato>) contatoRepository.findAll();
        }
        return contatoRepository.findAllByProdutosCategoriasNome(filtro.getCategoria().getNome());
    }
}
