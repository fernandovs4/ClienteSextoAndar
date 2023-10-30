package com.client.cliente.exception;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(String cpf){
        super("Não existe registro de usuário com o cpf: " + cpf);
    }
}
