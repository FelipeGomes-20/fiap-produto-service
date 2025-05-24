package org.fiap.api.exception;

import lombok.Getter;

@Getter
public class ProdutoExistenteException extends RuntimeException {
    public ProdutoExistenteException(String message) {
        super(message);
    }
}
