package com.zup.br.MarketingZup.controller;

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
    public List<Contato> listarContato(){
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

   // @GetMapping
   // public Iterable<AlbumDTO> retornarTodosOsAlbuns(@ModelAttribute FiltroDeAlbunsDTO filtro ){
        //Iterable<Album> albuns = albumService.pesquisarTodosOsAlbuns(filtro);
        //return AlbumDTO.converterIterableDeModelParaDTO(albuns);
    //}

}
