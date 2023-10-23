package com.client.demo.client;

import org.springframework.data.annotation.Id;

public class AluguelDto {
    @Id
    private String id;
    private String id_imovel;
    private String dataAluguel;
    private String cpf_corretor;
}
