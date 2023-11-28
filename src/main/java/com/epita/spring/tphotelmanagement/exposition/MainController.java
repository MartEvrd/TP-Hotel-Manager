package com.epita.spring.tphotelmanagement.exposition;

import com.epita.spring.tphotelmanagement.domaine.ClientEntity;
import com.epita.spring.tphotelmanagement.domaine.ReservationEntity;
import com.epita.spring.tphotelmanagement.infrastructure.ClientRepository;
import com.epita.spring.tphotelmanagement.infrastructure.ReservationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    private final ClientRepository clientRepository;
    private final ReservationRepository reservationRepository;

    public MainController(ClientRepository clientRepository, ReservationRepository reservationRepository) {
        this.clientRepository = clientRepository;
        this.reservationRepository = reservationRepository;

//        ClientEntity client = new ClientEntity(null, "Evrard", "Martin", "mart.evr@gmail.com", "0605040908", null, null, null);
//        clientRepository.save(client);
//
//        ReservationEntity res = new ReservationEntity(null, LocalDateTime.now(), LocalDateTime.now(), client);
//        reservationRepository.save(res);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientEntity>> findAllClients(){
        return ok(clientRepository.findAll());
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationEntity>> findAllReservations(){
        return ok(reservationRepository.findAll());
    }

}
