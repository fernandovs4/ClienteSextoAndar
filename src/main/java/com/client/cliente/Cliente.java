package com.client.cliente;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Cliente {
    @Id
    private String id;
    private String cpf;
    private String nome;
    private String endereco;
    private String dataNascimento;
    private double renda;
    private boolean ativo = true;
}

