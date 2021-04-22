package com.zup.br.MarketingZup.controller;

import com.zup.br.MarketingZup.dtos.ContatoDTO;
import com.zup.br.MarketingZup.dtos.FiltroDeContatosDTO;
import com.zup.br.MarketingZup.model.Contato;
import com.zup.br.MarketingZup.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato registrarContato(@RequestBody Contato contato){
        return contatoService.salvarContato(contato);
    }

    @GetMapping
    public List<Contato> listarContatos(){
        return contatoService.retornarTodosOsContatos();
    }


    @GetMapping("{id}/")
    public Contato buscarContatoPeloId(@PathVariable String id){
        return contatoService.buscarContatoPeloId(id);
    }

    @PutMapping("{id}/")
    public Contato atualizarContato(@PathVariable String id, Contato contato){
        return contatoService.atualizarContato(contato);
    }

    @DeleteMapping("{id}/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarContato(@PathVariable String id){
        contatoService.deletarContato(id);
    }

    @GetMapping("{produtos}/")
    public Iterable<ContatoDTO> retornarTodosOsContatosPelosProdutos(@ModelAttribute FiltroDeContatosDTO filtro ){
        Iterable<Contato> contatos = contatoService.pesquisarTodosOsContatosPelosProdutos(filtro);
        return ContatoDTO.converterIterableDeModelParaDTO(contatos);
    }

    @GetMapping("{categorias}/")
    public Iterable<ContatoDTO> retornarTodosOsContatosPelasCategorias(@ModelAttribute FiltroDeContatosDTO filtro ){
        Iterable<Contato> contatos = contatoService.pesquisarTodosOsContatosPelasCategorias(filtro);
        return ContatoDTO.converterIterableDeModelParaDTO(contatos);
    }

}
