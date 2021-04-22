package com.zup.br.MarketingZup.exceptions;

import com.zup.br.MarketingZup.dtos.ErroDeValidacaoDTO;
import com.zup.br.MarketingZup.dtos.RespostaDeErroDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ManipuladorDeExcecoes extends ResponseEntityExceptionHandler {
    private List<ErroDeValidacaoDTO> criarListaDeErrosDeValidacao(MethodArgumentNotValidException excecao) {
        List <ErroDeValidacaoDTO>erros = new ArrayList<>();

        for (FieldError erro: excecao.getFieldErrors()) {
            erros.add(new ErroDeValidacaoDTO(erro.getField(), erro.getDefaultMessage()));
        }

        return erros;
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException excecao, HttpHeaders headers, HttpStatus status, WebRequest request) {
        RespostaDeErroDTO resposta = new RespostaDeErroDTO(status, "validacao", criarListaDeErrosDeValidacao(excecao));

        return ResponseEntity.status(status).body(resposta);
    }

    /**
     * Trata os erros gerados pelo nosso sistema
     *
     * @param excecao o erro gerado pelo sistema
     * @return resposta de erro formatada
     */
    @ExceptionHandler({ErroDoSistema.class})
    public ResponseEntity lidaComErrosDoSistema(ErroDoSistema excecao) {
        RespostaDeErroDTO resposta = new RespostaDeErroDTO(excecao.getStatus(), excecao.getTipoDoErro(), excecao.getMessage());

        return ResponseEntity.status(resposta.getStatus()).body(resposta);
    }


    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity lidaComRuntimeException(RuntimeException excecao) {
        RespostaDeErroDTO resposta = new RespostaDeErroDTO(HttpStatus.BAD_REQUEST, "geral", excecao.getMessage());

        return ResponseEntity.status(resposta.getStatus()).body(resposta);
    }

}