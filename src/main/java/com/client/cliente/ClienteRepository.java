package com.client.cliente;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
    Cliente findByCpf(String cpf);
    List<Cliente> findByAtivo(boolean ativo);
    Cliente findByCpfAndAtivo(String cpf, boolean ativo);
}
