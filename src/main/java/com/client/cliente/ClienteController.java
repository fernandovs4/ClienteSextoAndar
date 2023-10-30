package com.client.cliente;

import java.util.List;

import com.client.cliente.exception.CpfAlreadyRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> excluirCliente(@PathVariable String cpf) {
        return clienteService.excluirCliente(cpf);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> detalhesCliente(@PathVariable String cpf) {
        return clienteService.detalhesCliente(cpf);
    }

    @GetMapping("/exists/{cpf}")
    public boolean validaCpf(@PathVariable String cpf) {
        return clienteService.validaCpf(cpf);
    }
}
