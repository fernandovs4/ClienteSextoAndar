package com.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaveClienteDTO {
    private String email;
    private String password;
    private List<String> roles;
}
