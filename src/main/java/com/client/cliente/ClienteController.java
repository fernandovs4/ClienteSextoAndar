package com.client.cliente;

import java.util.List;

import com.client.cliente.exception.CpfAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.client.cliente.dto.clienteDetalhesDto;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/exists/{cpf}")
    public Cliente validaCpf(@PathVariable String cpf) {
        return clienteService.validaCpf(cpf);
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> excluirCliente(@PathVariable String cpf) {
        return clienteService.excluirCliente(cpf);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<clienteDetalhesDto> detalhesCliente(@PathVariable String cpf) {
        return clienteService.detalhesCliente(cpf);
    }
}
