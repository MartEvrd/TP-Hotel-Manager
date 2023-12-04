package com.epita.spring.tphotelmanagement.exposition.controllers;

import com.epita.spring.tphotelmanagement.application.ChambreService;
import com.epita.spring.tphotelmanagement.application.ClientService;
import com.epita.spring.tphotelmanagement.application.ReservationService;
import com.epita.spring.tphotelmanagement.application.exceptions.EntityFormatException;
import com.epita.spring.tphotelmanagement.application.exceptions.ReservationDatesException;
import com.epita.spring.tphotelmanagement.domaine.ReservationEntity;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationClientIdChambreIdDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationGetClientGetChambreDto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final ChambreService chambreService;
    private final ClientService clientService;
    public ReservationController(ReservationService reservationService, ChambreService chambreService, ClientService clientService) {
        this.reservationService = reservationService;

        this.chambreService = chambreService;
        this.clientService = clientService;
    }

    @GetMapping("")
    public ResponseEntity<List<ReservationGetClientGetChambreDto>> findAllReservations(){
        return ok(reservationService.findAll()
                .stream()
                .map(ReservationConverterDto::convertToDtoFullReservation)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationGetClientGetChambreDto> findReservationById(@PathVariable("id") Long id) throws EntityNotFoundException {
        return ok(ReservationConverterDto.convertToDtoFullReservation(reservationService.findById(id)));
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<ReservationGetClientGetChambreDto>> findAllReservationsOfClient(@PathVariable("id") Long clientId) throws EntityNotFoundException{
        return ok(reservationService.findAllReservationsOfClient(clientId)
                .stream()
                .filter((resBdd) -> resBdd.getClient().getClientId() == clientId)
                .map(ReservationConverterDto::convertToDtoFullReservation)
                .toList());
    }

    @PostMapping("")
    public ResponseEntity<ReservationGetClientGetChambreDto> createReservation(@Valid @RequestBody ReservationClientIdChambreIdDto rDto)
            throws EntityNotFoundException, IllegalArgumentException, EntityFormatException, ReservationDatesException {

        ReservationEntity r = reservationService.createReservation(
                ReservationConverterDto.convertToEntityResGetClientGetChambreDto(
                        ReservationConverterDto.convertToDtoFullReservationIdDto(
                                rDto,
                                ClientConverterDto.convertToDtoClient(clientService.findById(rDto.getClient().getClientId())),
                                ChambreConverterDto.convertToDtoChambre(chambreService.findById(rDto.getChambre().getChambreId()))
                        )
                )
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(ReservationConverterDto.convertToDtoFullReservation(r));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") Long id) throws EntityNotFoundException{
        reservationService.deleteReservation(id);
        return ok("La réservation avec l'id n°"+id+" a été supprimée");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationGetClientGetChambreDto> updateReservation(@PathVariable("id") Long reservationId, @Valid @RequestBody ReservationClientIdChambreIdDto rDto)
            throws EntityNotFoundException, IllegalArgumentException, EntityFormatException, ReservationDatesException{

        ReservationEntity r = reservationService.updateReservation(
                ReservationConverterDto.convertToEntityResGetClientGetChambreDto(
                        ReservationConverterDto.convertToDtoFullReservationIdDto(
                                rDto,
                                ClientConverterDto.convertToDtoClient(clientService.findById(rDto.getClient().getClientId())),
                                ChambreConverterDto.convertToDtoChambre(chambreService.findById(rDto.getChambre().getChambreId()))
                        )
                ),
                reservationId
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(ReservationConverterDto.convertToDtoFullReservation(r));
    }








}
