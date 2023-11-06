package com.client.cliente.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


// public class aluguelDto {
//     private String identifier;
//     private String status;
//     private String cpfCorretor;
//     private String cpfLocatario;
//     private String idImovel;
//     private String dataAluguel;

// }

public class aluguelDto {
    @JsonProperty("identifier")
    private String identifier;
    @JsonProperty("status")
    private String status;
    @JsonProperty("cpfCorretor")
    private String cpfCorretor;

    @JsonProperty("idImovel")
    private String idImovel;
    @JsonProperty("dataAluguel")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dataAluguel;

    public aluguelDto(String identifier, String status, String cpfCorretor,  String idImovel, String dataAluguel) {
        this.identifier = identifier;
        this.status = status;
        this.cpfCorretor = cpfCorretor;

        this.idImovel = idImovel;
        this.dataAluguel = dataAluguel;
    }

    public aluguelDto() {
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public String getStatus() {
        return this.status;
    }

    public String getCpfCorretor() {
        return this.cpfCorretor;
    }


    public String getIdImovel() {
        return this.idImovel;
    }

    public String getDataAluguel() {
        return this.dataAluguel;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCpfCorretor(String cpfCorretor) {
        this.cpfCorretor = cpfCorretor;
    }
}