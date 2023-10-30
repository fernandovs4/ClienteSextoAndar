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
        Cliente cliente_db = clienteRepository.findByCpf(cliente.getCpf());
        if (cliente_db != null) {
            return null;  // criar exception de Já existe um user com o cpf cadastrado e retornar aqui
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepository.findByAtivo(true);
    }

    public ResponseEntity<String> excluirCliente(String cpf) {
        Cliente cliente = clienteRepository.findByCpfAndAtivo(cpf, true);
        if (cliente != null) {
            cliente.setAtivo(false);
            clienteRepository.save(cliente);
            return ResponseEntity.noContent().build();
        } else {
            return null; // criar exception de Cliente não encontrado e retornar aqui
        }
    }

    public ResponseEntity<Cliente> detalhesCliente(String cpf) {
        Cliente cliente = clienteRepository.findByCpfAndAtivo(cpf, true);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // verifies the token, use this on every route
    public int verifyUser(String token) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ReturnUserDTO> response = restTemplate.getForEntity("http://54.71.150.144:8082/login/" + token, ReturnUserDTO.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return 1;
        }
        return 0;
    }
}
