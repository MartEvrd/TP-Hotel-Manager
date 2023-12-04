package com.epita.spring.tphotelmanagement.application;

import com.epita.spring.tphotelmanagement.application.exceptions.EntityFormatException;
import com.epita.spring.tphotelmanagement.application.exceptions.ReservationDatesException;
import com.epita.spring.tphotelmanagement.domaine.ReservationEntity;
import com.epita.spring.tphotelmanagement.infrastructure.ReservationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class ReservationService {

    private final ReservationRepository repository;
    private final ChambreService chambreService;
    private final ClientService clientService;
    public ReservationService(ReservationRepository repository, ChambreService chambreService, ClientService clientService) {
        this.repository = repository;
        this.chambreService = chambreService;
        this.clientService = clientService;
    }

    public List<ReservationEntity> findAll(){
        return repository.findAll();
    }

    public ReservationEntity findById(Long id) throws EntityNotFoundException {
        ReservationEntity r = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("La réservation avec l'Id n°"+id+" n'existe pas"));
        return r;
    }

    public List<ReservationEntity> findAllReservationsOfClient(Long clientId) throws EntityNotFoundException {
        if(!clientService.clientExistsById(clientId)){
            throw new EntityNotFoundException("Le client avec l'id n°"+clientId+" n'existe pas en BDD. Il est nécessaire de le créer au préalable pour qu'il puisse réserver.");
        }
        return repository.findAll();
    }

    public ReservationEntity createReservation(ReservationEntity r)
            throws EntityNotFoundException, IllegalArgumentException, EntityFormatException, ReservationDatesException {
        Long chambreId = r.getChambre().getChambreId();
        Long clientId = r.getClient().getClientId();

        if(chambreId == null){
            throw new EntityFormatException("L'id de la chambre ne peut pas être null");
        }
        if(clientId == null){
            throw new EntityFormatException("L'id du client ne peut pas être null");
        }
        // Tester si la chambre fournie existe déjà en BDD -> sinon erreur pour indiquer de créer la chambre au préalable
        if(!chambreService.chambreExistsById(chambreId)){
            throw new EntityNotFoundException("La chambre avec l'id n°"+chambreId+" n'existe pas en BDD. Il est nécessaire de la créer au préalable pour effectuer une réservation sur cette chambre.");
        }
        // Tester si le client existe déjà en BDD -> sinon erreur pour indiquer de créer le client au préalable
        if(!clientService.clientExistsById(clientId)){
            throw new EntityNotFoundException("Le client avec l'id n°"+clientId+" n'existe pas en BDD. Il est nécessaire de le créer au préalable pour qu'il puisse réserver.");
        }

        // Vérification de la cohérence de choronologie des dates (la date de fin doit être après la date de début)
        if(r.getDateDebut() == null || r.getDateFin() == null || r.getDateFin().isBefore(r.getDateDebut())){
            throw new EntityFormatException("Les dates ne peuvent pas être nulles. Par ailleurs, la date de fin ne peut pas être antérieure à la date de début");
        }

//        ! PAS UTILE
//             *Tester si réservation déjà existante pour ce client dans la même période
//            // * 1. Une réservation est-elle déjà existante pour ce client ?
//            // * 2. Si oui -> est-ce que la date de début de la nouvelle réservation se trouve entre les 2 dates d'une réservation existante
//        List<ReservationEntity> reservationsOfClient = findAll()
//                .stream()
//                .filter((resBdd) -> resBdd.getClient().getClientId() == clientId)
//                .toList();
//        if (!reservationsOfClient.isEmpty()){
//           for(ReservationEntity rClient: reservationsOfClient){
//               if(dateOverlapping(rClient, r.getDateDebut(), r.getDateFin())){
//                   throw new ReservationDatesException("Impossible d'enregistrer la réservation à cette date, le client n°"+clientId+
//                           " a déjà réservé sur le même créneau (réservation n°"+rClient.getReservationId()+").");
//               }
//           }
//        }

        // * Tester si la chambre est déjà occupée sur la période de réservation sélectionnée
        List<ReservationEntity> reservationsOfChambre = findAll()
                .stream()
                .filter((resBdd) -> Objects.equals(resBdd.getChambre().getChambreId(), chambreId))
                .toList();
        if(!reservationsOfChambre.isEmpty()){
            for(ReservationEntity rChambre : reservationsOfChambre){
                if(dateOverlapping(rChambre, r.getDateDebut(), r.getDateFin())){
                    throw new ReservationDatesException("Impossible d'enregistrer la réservation à cette date, la chambre n°"+chambreId+
                            " est déjà occupée (réservation n°"+rChambre.getReservationId()+").");
                }
            }
        }
        return repository.save(r);
    }

    public void deleteReservation(Long id) throws EntityNotFoundException{
        ReservationEntity r = repository.findById(id).orElseThrow(()-> new EntityNotFoundException("La réservation avec l'Id n°"+id+" n'existe pas"));
        repository.delete(r);
    }

    public ReservationEntity updateReservation(ReservationEntity r, Long reservationId)
            throws EntityNotFoundException, IllegalArgumentException, EntityFormatException, ReservationDatesException{

        Long chambreId = r.getChambre().getChambreId();
        Long clientId = r.getClient().getClientId();

        ReservationEntity rBdd = repository.findById(reservationId).orElseThrow(()-> new EntityNotFoundException("La réservation avec l'Id n°"+reservationId+" n'existe pas"));

        if(clientId == null){
            throw new EntityFormatException("L'id du client ne peut pas être null");
        }
        if(!clientService.clientExistsById(clientId)){
            throw new EntityNotFoundException("Le client avec l'id n°"+clientId+" n'existe pas en BDD.");
        }
        if(!clientId.equals(rBdd.getClient().getClientId())){
            throw new EntityFormatException("Il est interdit de modifier le client d'une réservation");
        }

        if(chambreId == null){
            throw new EntityFormatException("L'id de la chambre ne peut pas être null");
        }
        if(!chambreService.chambreExistsById(chambreId)){
            throw new EntityNotFoundException("La chambre avec l'id n°"+chambreId+" n'existe pas en BDD.");
        }
        // Vérification de la cohérence de choronologie des dates (la date de fin doit être après la date de début)
        if(r.getDateDebut() == null || r.getDateFin() == null || r.getDateFin().isBefore(r.getDateDebut())){
            throw new EntityFormatException("Les dates ne peuvent pas être nulles. Par ailleurs, la date de fin ne peut pas être antérieure à la date de début");
        }

        List<ReservationEntity> reservationsOfChambre = findAll()
                .stream()
                .filter((listResBdd) -> !Objects.equals(listResBdd.getReservationId(), reservationId))
                .filter((listResBdd) -> Objects.equals(listResBdd.getChambre().getChambreId(), chambreId))
                .toList();
        if(!reservationsOfChambre.isEmpty()){
            for(ReservationEntity rChambre : reservationsOfChambre){
                if(dateOverlapping(rChambre, r.getDateDebut(), r.getDateFin())){
                    throw new ReservationDatesException("Impossible de modifier la réservation sur ces dates, la chambre n°"+chambreId+
                            " est déjà occupée (réservation n°"+rChambre.getReservationId()+").");
                }
            }
        }

        rBdd.setChambre(r.getChambre());
        rBdd.setDateDebut(r.getDateDebut());
        rBdd.setDateFin(r.getDateFin());

        return repository.save(rBdd);
    }

    private static boolean dateOverlapping(ReservationEntity r, LocalDate newDateDebut, LocalDate newDateFin){
        LocalDate dateDebut = r.getDateDebut();
        LocalDate dateFin = r.getDateFin();

        // Date de début dans la période réservée
        if(newDateDebut.isBefore(dateFin) && (newDateDebut.isAfter(dateDebut)||newDateDebut.isEqual(dateDebut))){
            System.out.println("---------------------------------------");
            System.out.println("1 // Date de début dans la période réservée");
            System.out.println("---------------------------------------");

            return true;
        }
        // Date de fin dans la période réservée
        if(newDateFin.isAfter(dateDebut) && (newDateFin.isBefore(dateFin) || newDateFin.isEqual(dateFin))){
            System.out.println("---------------------------------------");
            System.out.println("2 // Date de fin dans la période réservée");
            System.out.println("---------------------------------------");

            return true;
        }
        // Chevauchement complet d'une autre réservation
        if(newDateDebut.isBefore(dateDebut) && newDateFin.isAfter(dateFin)){
            System.out.println("---------------------------------------");
            System.out.println("3 // Chevauchement de la période réservée");
            System.out.println("---------------------------------------");

            return true;
        }
        return false;
    }
}
