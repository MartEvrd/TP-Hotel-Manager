package com.epita.spring.tphotelmanagement.exposition.controllers;

import com.epita.spring.tphotelmanagement.application.ChambreService;
import com.epita.spring.tphotelmanagement.application.ClientService;
import com.epita.spring.tphotelmanagement.application.ReservationService;
import com.epita.spring.tphotelmanagement.application.ServiceService;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreWithReservationDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientWithReservationDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationGetClientGetChambreDto;
import com.epita.spring.tphotelmanagement.exposition.dto.service.ServiceConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.service.ServiceWithChambreServiceByServiceDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
public class ReservationController {

    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;

    }

    @GetMapping("/reservation")
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

//    @PostMapping("/reservation")
//    public ResponseEntity<ReservationGetClientGetChambreDto> createReservation(@RequestBody ReservationGetClientGetChambreDto reservationGetClientGetChambreDto) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(
//                ReservationConverterDto.convertToDtoFullReservation(
//                        reservationRepository.save(
//                                ReservationConverterDto.convertToEntityResGetClientGetChambreDto(reservationGetClientGetChambreDto)
//                        )
//                )
//        );
//    }

}
