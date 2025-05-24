package org.fiap.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler  {

    @ExceptionHandler(ProdutoExistenteException.class)
    public ResponseEntity<ErroResponse> handleClienteExistente(ProdutoExistenteException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErroResponse("produto.existente", ex.getMessage()));
    }

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> handleNotFound(ProdutoNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroResponse("produto.nao_encontrado", ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> handleGeneric(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErroResponse("erro.interno", ex.getMessage()));
    }

    public record ErroResponse(String code, String message, LocalDateTime timestamp) {
        public ErroResponse(String code, String message) {
            this(code, message, LocalDateTime.now());
        }
    }
}
