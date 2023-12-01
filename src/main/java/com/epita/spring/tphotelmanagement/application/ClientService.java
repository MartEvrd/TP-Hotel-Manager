package com.epita.spring.tphotelmanagement.application;

import com.epita.spring.tphotelmanagement.domaine.ClientEntity;
import com.epita.spring.tphotelmanagement.infrastructure.ClientRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    ClientRepository repository;
    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public List<ClientEntity> findAll(){
        return repository.findAll();
    }

    public ClientEntity findById(Long id) throws EntityNotFoundException {
        ClientEntity c = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Le client avec l'Id n°"+id+" n'existe pas"));
        return c;
    }

    public ClientEntity createClient(ClientEntity c) throws IllegalArgumentException, EntityExistsException{
        if(c == null){
            throw new IllegalArgumentException("Objet client null lors de l'enregistrement");
        }
        if(repository.existsByEmail(c.getEmail())){
            throw new EntityExistsException("Client avec cet email déjà existant");
        }
        return repository.save(c);
    }

    public void deleteClient(Long id) throws EntityNotFoundException{
        ClientEntity c = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Le client avec l'Id n°"+id+" n'existe pas"));
        repository.delete(c);
    }

    public ClientEntity updateClient(ClientEntity c, Long id) throws IllegalArgumentException, EntityNotFoundException, EntityExistsException{
        if(c == null){
            throw new IllegalArgumentException("Objet client null lors de l'enregistrement");
        }
        ClientEntity cBase = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Le client avec l'Id n°"+id+" n'existe pas, impossible de le modifier"));

        if((c.getEmail() != cBase.getEmail()) && repository.existsByEmail(c.getEmail())){
            throw new EntityExistsException("Client avec cet email déjà existant");
        } else {
            cBase.setEmail(c.getEmail());
        }
        if(c.getNom() != cBase.getNom()){
            cBase.setNom(c.getNom());
        }
        if(c.getPrenom() != cBase.getPrenom()){
            cBase.setPrenom(c.getPrenom());
        }
        if(c.getTelephone() != cBase.getTelephone()){
            cBase.setTelephone(c.getTelephone());
        }

        return repository.save(cBase);
    }
}
