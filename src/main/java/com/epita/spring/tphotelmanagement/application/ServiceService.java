package com.epita.spring.tphotelmanagement.application;

import com.epita.spring.tphotelmanagement.application.exceptions.EntityFormatException;
import com.epita.spring.tphotelmanagement.domaine.ChambreEntity;
import com.epita.spring.tphotelmanagement.domaine.ServiceEntity;
import com.epita.spring.tphotelmanagement.infrastructure.ServiceRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public ServiceEntity createService(ServiceEntity s) throws EntityExistsException, EntityFormatException {
        if(s == null){
            throw new EntityFormatException("Service null lors de l'enregistrement");
        }
        if(repository.existsByNom(s.getNom())){
            throw new EntityExistsException("Service avec ce nom déjà existant");
        }
        return repository.save(s);
    }

    public void deleteService(Long id) throws EntityNotFoundException{
        ServiceEntity s = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Le service avec l'Id n°"+id+" n'existe pas"));
        repository.delete(s);
    }

    public ServiceEntity updateService(ServiceEntity s, Long id) throws EntityFormatException, EntityNotFoundException, EntityExistsException{
        if(s == null){
            throw new EntityFormatException("Service null lors de l'enregistrement");
        }
        ServiceEntity sBdd = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Le service avec l'Id n°"+id+" n'existe pas, impossible de le modifier"));

        if((!Objects.equals(s.getNom(), sBdd.getNom())) && repository.existsByNom(s.getNom())){
            throw new EntityExistsException("Service avec ce nom déjà existant");
        } else {
            s.setNom(s.getNom());
        }
        if(!Objects.equals(s.getDescription(), sBdd.getDescription())){
            sBdd.setDescription(s.getDescription());
        }
        if(!Objects.equals(s.getTarif(), sBdd.getTarif())){
            sBdd.setTarif(s.getTarif());
        }
        return repository.save(sBdd);
    }

}
