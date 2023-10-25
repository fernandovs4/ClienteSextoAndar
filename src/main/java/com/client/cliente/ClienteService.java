package com.client.cliente;

import com.client.cliente.dto.ReturnUserDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;




@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public ResponseEntity<String> excluirCliente(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        if (cliente != null) {
            cliente.setAtivo(false);
            clienteRepository.save(cliente);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Cliente> detalhesCliente(String cpf) {
        Cliente cliente = clienteRepository.findByCpf(cpf);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // verifies the token, use this on every route
    public ReturnUserDTO verifyUser(String token) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ReturnUserDTO> response = restTemplate.getForEntity("http://54.71.150.144:8082/login/" + token, ReturnUserDTO.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return null;
    }
}
