

package com.client.common;

import com.client.common.exception.NoTokenInHeaderException;
import com.client.common.exception.TokenNotValidException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
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
        HttpServletResponse res = (HttpServletResponse) response;

        try {
            String token = req.getHeader("token");
            if (token == null) throw new NoTokenInHeaderException();
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<userDTO> responsey = restTemplate.getForEntity("http://54.71.150.144:8082/token/" + token, userDTO.class);
            if (responsey.getStatusCode().is2xxSuccessful()) {
                chain.doFilter(request, response);
            } else {
                throw new TokenNotValidException();
            }

        } catch (RestClientException e) { // Catching a broader range of exceptions
            // Handle the exception by writing a response or logging it
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("application/json");
            res.getWriter().write(String.format("{\"error\": \"Token de autenticação inválido.\"}"));
            return; // Ensure that processing stops here
        }

        // This might be redundant now, but can stay here to catch other custom exceptions
        catch (NoTokenInHeaderException | TokenNotValidException e) {
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.setContentType("application/json");
            res.getWriter().write(String.format("{\"error\": \"%s\"}", e.getMessage()));
            return; // Ensure that processing stops here
        }
    }
}