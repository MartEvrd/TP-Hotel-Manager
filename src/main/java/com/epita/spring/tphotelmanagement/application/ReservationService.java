package com.epita.spring.tphotelmanagement.application;

import com.epita.spring.tphotelmanagement.domaine.ReservationEntity;
import com.epita.spring.tphotelmanagement.infrastructure.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository repository;
    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<ReservationEntity> findAll(){
        return repository.findAll();
    }

    public ReservationEntity findById(Long id) throws EntityNotFoundException {
        ReservationEntity r = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("La réservation avec l'Id n°"+id+" n'existe pas"));
        return r;
    }
}
