package com.client.cliente.dto;

// public class vendaDto {
//     private String imovelIdentifier;
//     private String cpfCliente;
//     private String cpfCorretor;
//     private String vendaStatus;
// }

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class vendaDto {
    @JsonProperty("imovelIdentifier")
    private String imovelIdentifier;

    @JsonProperty("cpfCorretor")
    private String cpfCorretor;
    @JsonProperty("vendaStatus")
    private String vendaStatus;
    @JsonProperty("dataVenda")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private String dataVenda;

    public vendaDto(String imovelIdentifier, String cpfCorretor, String vendaStatus, String dataVenda) {
        this.imovelIdentifier = imovelIdentifier;
        this.cpfCorretor = cpfCorretor;
        this.vendaStatus = vendaStatus;
        this.dataVenda = dataVenda;
    }

    public vendaDto() {
    }

    public String getImovelIdentifier() {
        return this.imovelIdentifier;
    }


    public String getCpfCorretor() {
        return this.cpfCorretor;
    }

    public String getVendaStatus() {
        return this.vendaStatus;
    }

    public String getDataVenda() {
        return this.dataVenda;
    }
}