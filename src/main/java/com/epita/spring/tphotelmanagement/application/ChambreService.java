package com.epita.spring.tphotelmanagement.application;

import com.epita.spring.tphotelmanagement.domaine.ChambreEntity;
import com.epita.spring.tphotelmanagement.infrastructure.ChambreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChambreService {

    private final ChambreRepository repository;
    public ChambreService(ChambreRepository repository) {
        this.repository = repository;
    }

    public List<ChambreEntity> findAll(){
        return repository.findAll();
    }

    public ChambreEntity findById(Long id) throws EntityNotFoundException {
        ChambreEntity ch = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("La chambre avec l'Id n°"+id+" n'existe pas"));
        return ch;
    }


}

