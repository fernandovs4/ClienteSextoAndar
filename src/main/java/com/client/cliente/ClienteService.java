package com.client.cliente;


import java.util.Arrays;
import java.util.List;

import com.client.cliente.dto.aluguelDto;
import com.client.cliente.exception.ClienteNotFoundException;
import com.client.cliente.exception.CpfAlreadyRegisteredException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.client.cliente.dto.clienteDetalhesDto;
import com.client.cliente.dto.vendaDto;

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

    public ResponseEntity<clienteDetalhesDto> detalhesCliente(String cpf, String token) {
        Cliente cliente = clienteRepository.findByCpfAndAtivo(cpf, true);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.set("token", token);
        HttpEntity<String> entity = new HttpEntity<>(headers);

         // Chamando a rota de aluguel --> http://18.236.255.187:8080/aluguel?cpfLocatario=
         ResponseEntity<aluguelDto[]> responseAluguel = restTemplate.exchange(
            "http://18.236.255.187:8080/aluguel?cpfLocatario=" + cpf,
            HttpMethod.GET,
            entity,
            aluguelDto[].class);

        aluguelDto[] alugueis = responseAluguel.getBody();
        
        // Chamando a rota de vendas --> http://35.88.107.128:8080/vendas/cliente?clienteCpf=
        ResponseEntity<vendaDto[]> responseVenda = restTemplate.exchange(
                "http://35.88.107.128:8080/vendas/cliente?clienteCpf=" + cpf,
                HttpMethod.GET,
                entity,
                vendaDto[].class);

        vendaDto[] vendas = responseVenda.getBody();

        clienteDetalhesDto clienteDetalhes = new clienteDetalhesDto();
        clienteDetalhes.setNome(cliente.getNome());
        clienteDetalhes.setCpf(cliente.getCpf());
        clienteDetalhes.setEndereco(cliente.getEndereco());
        clienteDetalhes.setDataNascimento(cliente.getDataNascimento());
        clienteDetalhes.setRenda(cliente.getRenda());
        clienteDetalhes.setAlugueis(Arrays.asList(alugueis));
        clienteDetalhes.setVendas(Arrays.asList(vendas));
        
        return ResponseEntity.ok(clienteDetalhes);
    }

    public Cliente validaCpf(String cpf) {
        Cliente cliente = clienteRepository.findByCpfAndAtivo(cpf, true);
        if (cliente != null) {
            return cliente;
        } else {
            throw new ClienteNotFoundException(cpf);
        }
    }
}
