package com.zup.br.MarketingZup.service;

import com.zup.br.MarketingZup.dtos.FiltroDeContatosDTO;
import com.zup.br.MarketingZup.model.Contato;
import com.zup.br.MarketingZup.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ContatoService {

@Autowired
    private ContatoRepository contatoRepository;

    public Contato salvarContato(Contato contato){
        try{
            Contato obj = contatoRepository.save(contato);
            return contato;
        }catch (Exception error){
            throw new RuntimeException("Contato já cadastrado!");
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


    public Iterable<Contato> pesquisarTodosOsContatos(FiltroDeContatosDTO filtro){
        if(filtro.getProduto() == null){
            return contatoRepository.findAll();
        }
        return contatoRepository.findAllByProdutosNome(filtro.getProduto().getNome());
    }
}
