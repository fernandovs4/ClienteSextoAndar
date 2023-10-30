package com.client.cliente.exception;

public class CpfAlreadyRegisteredException extends RuntimeException{
    public CpfAlreadyRegisteredException(String cpf){
        super("Já existe um usuário cadastrado com o CPF: " + cpf + ". O sistema não permite um novo cadastro com um cpf já usado mesmo que a conta tenha sido excluida.");
    }
}
