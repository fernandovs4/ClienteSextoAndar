package com.client.cliente.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

import com.client.cliente.User;

@Getter
@Setter
public class ReturnUserDTO {
    private String email;
    private String password;
    private List<String> roles;

    public static ReturnUserDTO convert(User user) {
        ReturnUserDTO userDTO = new ReturnUserDTO();
        userDTO.setEmail(user.getEmail());
        userDTO.setRoles(user.getRoles());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

}
