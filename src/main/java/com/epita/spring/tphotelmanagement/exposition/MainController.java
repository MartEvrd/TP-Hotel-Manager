package com.epita.spring.tphotelmanagement.exposition;

import com.epita.spring.tphotelmanagement.domaine.*;
import com.epita.spring.tphotelmanagement.domaine.enums.TypeChambreEnum;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreWithReservationDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientWithReservationDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationGetClientGetChambreDto;
import com.epita.spring.tphotelmanagement.exposition.dto.service.ServiceConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.service.ServiceWithChambreServiceByServiceDto;
import com.epita.spring.tphotelmanagement.infrastructure.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
public class MainController {

    private final ClientRepository clientRepository;
    private final ReservationRepository reservationRepository;
    private final ChambreRepository chambreRepository;
    private final ServiceRepository serviceRepository;
    private final ChambreServiceRepository chambreServiceRepository;

    public MainController(ClientRepository clientRepository, ReservationRepository reservationRepository, ClientConverterDto clientConverterDto, ReservationConverterDto reservationConverterDto, ChambreRepository chambreRepository,
                          ServiceRepository serviceRepository, ChambreServiceRepository chambreServiceRepository) {
        this.clientRepository = clientRepository;
        this.reservationRepository = reservationRepository;
        this.chambreRepository = chambreRepository;
        this.chambreServiceRepository = chambreServiceRepository;

        ClientEntity client = new ClientEntity(null, "Evrard", "Martin", "mart.evr@gmail.com", "0605040908", null, null, null);
        clientRepository.save(client);

        ChambreEntity chambre = new ChambreEntity(null, "101", TypeChambreEnum.LIT_DOUBLE, 98.78, false, null, null, null, null);
        chambreRepository.save(chambre);

        ServiceEntity service = new ServiceEntity(null, "Wifi", "connexion wifi en chambre", 3.65, null, null, null);
        serviceRepository.save(service);

        ChambreServiceId csId = new ChambreServiceId();

        ChambreServiceEntity chambreService = new ChambreServiceEntity(csId, chambre, service, LocalDate.now(), LocalTime.now(), "wifi");
        chambreServiceRepository.save(chambreService);

        ReservationEntity res = new ReservationEntity(null, LocalDateTime.now(), LocalDateTime.now(), client, chambre, null,null);
        reservationRepository.save(res);
        this.serviceRepository = serviceRepository;
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientWithReservationDto>> findAllClients(){
        return ok(clientRepository.findAll()
                .stream()
                .map(ClientConverterDto::convertToDtoClientWithReservation)
                .toList());
    }

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationGetClientGetChambreDto>> findAllReservations(){
        return ok(reservationRepository.findAll()
                .stream()
                .map(ReservationConverterDto::convertToDtoFullReservation)
                .toList());
    }

    @GetMapping("/chambres")
    public ResponseEntity<List<ChambreWithReservationDto>> getAllChambres(){
        return ok(chambreRepository.findAll()
                .stream()
                .map(ChambreConverterDto::convertToDtoChambreWithReservation)
                .toList());
    }

    @GetMapping("/services")
    public ResponseEntity<List<ServiceWithChambreServiceByServiceDto>> findAllServices(){
        return ok(serviceRepository.findAll()
                .stream()
                .map(ServiceConverterDto::convertToDtoServiceWithChambreServiceByService)
                .toList());
    }

}
