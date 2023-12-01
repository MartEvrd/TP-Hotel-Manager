package com.epita.spring.tphotelmanagement.application;

import com.epita.spring.tphotelmanagement.domaine.ServiceEntity;
import com.epita.spring.tphotelmanagement.infrastructure.ServiceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceService {

    private final ServiceRepository repository;
    public ServiceService(ServiceRepository repository) {
        this.repository = repository;
    }

    public List<ServiceEntity> findAll(){
        return repository.findAll();
    }

    public ServiceEntity findById(Long id) throws EntityNotFoundException {
        ServiceEntity s = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Le service avec l'Id n°"+id+" n'existe pas"));
        return s;
    }

}
