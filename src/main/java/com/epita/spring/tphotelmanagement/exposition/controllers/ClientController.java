package com.epita.spring.tphotelmanagement.exposition.controllers;

import com.epita.spring.tphotelmanagement.application.ChambreService;
import com.epita.spring.tphotelmanagement.application.ClientService;
import com.epita.spring.tphotelmanagement.application.ReservationService;
import com.epita.spring.tphotelmanagement.application.ServiceService;
import com.epita.spring.tphotelmanagement.application.exceptions.EntityFormatException;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientWithReservationDto;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService, ReservationService reservationService, ChambreService chambreService, ServiceService serviceService) {
        this.clientService = clientService;
    }

    @GetMapping("")
    public ResponseEntity<List<ClientWithReservationDto>> findAllClients(){
        return ok(clientService.findAll()
                .stream()
                .map(ClientConverterDto::convertToDtoClientWithReservation)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientWithReservationDto> findClientById(@PathVariable("id") Long id) throws EntityNotFoundException{
        return ok(ClientConverterDto.convertToDtoClientWithReservation(clientService.findById(id)));
    }

    @PostMapping("")
    public ResponseEntity<ClientWithReservationDto> createClient(@Valid @RequestBody ClientDto cDto) throws EntityFormatException, EntityExistsException {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ClientConverterDto.convertToDtoClientWithReservation(
                        clientService.createClient(ClientConverterDto.convertToEntityClientDto(cDto))));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable("id") Long id) throws EntityNotFoundException{
        clientService.deleteClient(id);
        return ok("Le client avec l'id n°"+id+" a été supprimé");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientWithReservationDto> updateClient(@PathVariable("id") Long id, @Valid @RequestBody ClientDto cDto) throws EntityFormatException, EntityNotFoundException, EntityExistsException{
        ClientWithReservationDto cWithResDto = ClientConverterDto.convertToDtoClientWithReservation(
                clientService.updateClient(ClientConverterDto.convertToEntityClientDto(cDto), id));
        return ok(cWithResDto);
    }
}
