package com.client.dto;

import com.client.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReturnClienteDTO {
    private String email;
    private String password;
    private List<String> roles;

    public static ReturnClienteDTO convert(Cliente cliente) {
        ReturnClienteDTO clienteDTO = new ReturnClienteDTO();
        clienteDTO.setEmail(cliente.getEmail());
        clienteDTO.setRoles(cliente.getRoles());
        clienteDTO.setPassword(cliente.getPassword());
        return clienteDTO;
    }

}
