package com.client.cliente.dto;

import java.util.List;

import com.client.cliente.AluguelDto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public class clienteDetalhesDto {
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("cpf")
    private String cpf;
    @JsonProperty("endereco")
    private String endereco;
    @JsonProperty("dataNascimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dataNascimento;
    @JsonProperty("renda")
    private double renda;
    @JsonProperty("alugueis")
    private List<AluguelDto> alugueis;
    @JsonProperty("vendas")
    private List<vendaDto> vendas;

    public clienteDetalhesDto(String nome, String cpf, String endereco, String dataNascimento, double renda, List<AluguelDto> alugueis, List<vendaDto> vendas) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.renda = renda;
        this.alugueis = alugueis;
        this.vendas = vendas;
    }

    public clienteDetalhesDto() {
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public double getRenda() {
        return this.renda;
    }

    public List<AluguelDto> getAlugueis() {
        return this.alugueis;
    }

    public List<vendaDto> getVendas() {
        return this.vendas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public void setAlugueis(List<AluguelDto> alugueis) {
        this.alugueis = alugueis;
    }

    public void setVendas(List<vendaDto> vendas) {
        this.vendas = vendas;
    }

}