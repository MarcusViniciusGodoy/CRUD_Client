package com.desafio3.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.desafio3.dscommerce.DTO.ClientDTO;
import com.desafio3.dscommerce.entities.Client;
import com.desafio3.dscommerce.repository.ClientRepository;
import com.desafio3.dscommerce.services.exceptions.ResourceNotFoundException;

@Service
public class ClientService {

    @Autowired
    private ClientRepository repository;

    @Transactional(readOnly = true)
    public ClientDTO findById(Long id){
            Client client = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado."));
            return new ClientDTO(client);
    }

    @Transactional(readOnly = true)
    public Page<ClientDTO> findAll(Pageable pageable){
        Page<Client> result = repository.findAll(pageable);
        return result.map(x -> new ClientDTO(x));
    }
}
