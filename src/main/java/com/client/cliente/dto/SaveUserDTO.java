package com.client.cliente.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaveUserDTO {
    private String email;
    private String password;
    private List<String> roles;
}
