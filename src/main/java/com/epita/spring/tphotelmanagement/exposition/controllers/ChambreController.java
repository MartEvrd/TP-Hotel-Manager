package com.epita.spring.tphotelmanagement.exposition.controllers;

import com.epita.spring.tphotelmanagement.application.ChambreService;
import com.epita.spring.tphotelmanagement.application.ClientService;
import com.epita.spring.tphotelmanagement.application.ReservationService;
import com.epita.spring.tphotelmanagement.application.ServiceService;
import com.epita.spring.tphotelmanagement.application.exceptions.EntityFormatException;
import com.epita.spring.tphotelmanagement.domaine.ChambreEntity;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreDto;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreWithReservationDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientWithReservationDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationGetClientGetChambreDto;
import com.epita.spring.tphotelmanagement.exposition.dto.service.ServiceConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.service.ServiceWithChambreServiceByServiceDto;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/chambre")
public class ChambreController {

    private final ChambreService chambreService;

    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @GetMapping("")
    public ResponseEntity<List<ChambreWithReservationDto>> getAllChambres(){
        return ok(chambreService.findAll()
                .stream()
                .map(ChambreConverterDto::convertToDtoChambreWithReservation)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChambreWithReservationDto> getChambreById(@PathVariable("id") Long id){
        return ok(ChambreConverterDto.convertToDtoChambreWithReservation(chambreService.findById(id)));
    }

    @PostMapping()
    public ResponseEntity<ChambreWithReservationDto> createChambre(@Valid @RequestBody ChambreDto chDto) throws EntityExistsException, EntityFormatException {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ChambreConverterDto.convertToDtoChambreWithReservation(
                        chambreService.createChambre(ChambreConverterDto.convertToEntityChambreDto(chDto))
                ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChambre(@PathVariable("id") Long id) throws EntityNotFoundException {
        chambreService.deleteChambre(id);
        return ok("La chambre avec l'id n°"+id+" a été supprimée");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChambreWithReservationDto> updateChambre(@PathVariable("id") Long id, @Valid @RequestBody ChambreDto chDto) throws EntityFormatException, EntityNotFoundException, EntityExistsException{
        ChambreWithReservationDto chWithResDto = ChambreConverterDto.convertToDtoChambreWithReservation(
                chambreService.updateChambre(ChambreConverterDto.convertToEntityChambreDto(chDto), id));
        return ok(chWithResDto);
    }
}
