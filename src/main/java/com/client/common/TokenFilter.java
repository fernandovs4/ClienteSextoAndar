package com.client.common;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.client.cliente.dto.userDTO;

import java.io.IOException;

@Component
@Order(1)
public class TokenFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String token = req.getHeader("token");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<userDTO> responsey = restTemplate.getForEntity("http://54.71.150.144:8082/token/" + token, userDTO.class);
        if (responsey.getStatusCode().is2xxSuccessful()) {
            chain.doFilter(request, response);
        } else {
            throw new RuntimeException("User not found");
        }

    }

}