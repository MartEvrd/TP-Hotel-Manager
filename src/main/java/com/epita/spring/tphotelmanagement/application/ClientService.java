package com.epita.spring.tphotelmanagement.application;

import com.epita.spring.tphotelmanagement.domaine.ClientEntity;
import com.epita.spring.tphotelmanagement.infrastructure.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<ClientEntity> findAllClient(){
        return repository.findAll();
    }
}
