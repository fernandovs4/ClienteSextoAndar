package com.client.common.exception;

public class TokenNotValidException  extends RuntimeException{
    public TokenNotValidException() {
        super("Token de autenticação inválido.");
    }
}
