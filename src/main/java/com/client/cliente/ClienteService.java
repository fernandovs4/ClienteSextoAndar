package com.client.cliente;

import java.util.List;

import com.client.cliente.exception.ClienteNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import  com.client.cliente.exception.CpfAlreadyRegisteredException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente){
        Cliente cliente_db = clienteRepository.findByCpf(cliente.getCpf());
        if (cliente_db != null) {
            throw new CpfAlreadyRegisteredException(cliente.getCpf());
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
            throw new ClienteNotFoundException(cpf); // criar exception de Cliente não encontrado e retornar aqui
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

    public boolean validaCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpfAndAtivo(cpf, true);
        if (cliente != null) {
            return true;
        } else {
            return false;
        }
    }

    

}
