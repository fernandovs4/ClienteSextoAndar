package com.client.cliente;

import java.util.List;

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
        if (verifyUser(token)){
            return clienteService.criarCliente(cliente);
        }
        return null;
    }

    @GetMapping
    public List<Cliente> listarClientes() {
        if (verifyUser(token)){
            return clienteService.listarClientes();
        }  
        return null;
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> excluirCliente(@PathVariable String cpf) {
        if (verifyUser(token)){
            return clienteService.excluirCliente(cpf);
        }  
        return null;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> detalhesCliente(@PathVariable String cpf) {
        if (verifyUser(token)){
            return clienteService.detalhesCliente(cpf);
        }  
        return null;
    }
}
