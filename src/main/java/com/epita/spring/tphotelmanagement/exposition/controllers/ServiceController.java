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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/service")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("")
    public ResponseEntity<List<ServiceWithChambreServiceByServiceDto>> findAllServices(){
        return ok(serviceService.findAll()
                .stream()
                .map(ServiceConverterDto::convertToDtoServiceWithChambreServiceByService)
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceWithChambreServiceByServiceDto> findServiceById(@PathVariable("id") Long id){
        return ok(ServiceConverterDto.convertToDtoServiceWithChambreServiceByService(serviceService.findById(id)));
    }
}
