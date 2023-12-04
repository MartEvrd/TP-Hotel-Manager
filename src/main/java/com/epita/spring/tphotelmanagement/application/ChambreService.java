package com.epita.spring.tphotelmanagement.application;

import com.epita.spring.tphotelmanagement.application.exceptions.EntityFormatException;
import com.epita.spring.tphotelmanagement.domaine.ChambreEntity;
import com.epita.spring.tphotelmanagement.domaine.ClientEntity;
import com.epita.spring.tphotelmanagement.infrastructure.ChambreRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    public boolean chambreExistsById(Long id){
        return repository.existsById(id);
    }

    public ChambreEntity createChambre(ChambreEntity ch) throws EntityExistsException, EntityFormatException {
        if(ch == null){
            throw new EntityFormatException("Objet chambre null lors de l'enregistrement");
        }
        if(repository.existsByNumero(ch.getNumero())){
            throw new EntityExistsException("Chambre avec ce numéro déjà existante");
        }
        return repository.save(ch);
    }

    public void deleteChambre(Long id) throws EntityNotFoundException{
        ChambreEntity ch = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("La chambre avec l'Id n°"+id+" n'existe pas"));
        repository.delete(ch);
    }

    public ChambreEntity updateChambre(ChambreEntity ch, Long id) throws EntityFormatException, EntityNotFoundException, EntityExistsException{
        if(ch == null){
            throw new EntityFormatException("Objet chambre null lors de l'enregistrement");
        }
        ChambreEntity chBase = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("La chambre avec l'Id n°"+id+" n'existe pas, impossible de le modifier"));

        if((!Objects.equals(ch.getNumero(), chBase.getNumero())) && repository.existsByNumero(ch.getNumero())){
            throw new EntityExistsException("Chambre avec ce numéro déjà existante");
        } else {
            chBase.setNumero(ch.getNumero());
        }
        if(ch.getType() != chBase.getType()){
            chBase.setType(ch.getType());
        }
        if(ch.getPrixNuit() != chBase.getPrixNuit()){
            chBase.setPrixNuit(ch.getPrixNuit());
        }
        if(ch.getDisponible() != chBase.getDisponible()){
            chBase.setDisponible(ch.getDisponible());
        }
        return repository.save(chBase);
    }

}

