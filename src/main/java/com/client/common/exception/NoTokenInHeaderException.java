package com.client.common.exception;

public class NoTokenInHeaderException extends RuntimeException{

    public NoTokenInHeaderException(){
        super("Nenhum token de autenticação presente no Header.");
    }
}
