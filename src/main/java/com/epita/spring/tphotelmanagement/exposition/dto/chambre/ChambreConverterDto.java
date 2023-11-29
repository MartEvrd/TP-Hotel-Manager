package com.epita.spring.tphotelmanagement.exposition.dto.chambre;

import com.epita.spring.tphotelmanagement.domaine.ChambreEntity;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre_service.ChambreServiceByChambreDto;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre_service.ChambreServiceConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationByChambreDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationConverterDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChambreConverterDto {

    // Conversion d'une chambre standard en chambre sans réservation
    public static ChambreDto convertToDtoChambre(ChambreEntity chambre){
        ChambreDto chambreDto = new ChambreDto();
        chambreDto.setChambreId(chambre.getChambreId());
        chambreDto.setNumero(chambre.getNumero());
        chambreDto.setType(chambre.getType());
        chambreDto.setPrixNuit(chambre.getPrixNuit());
        chambreDto.setDisponible(chambre.getDisponible());
        return chambreDto;
    }

    public static ChambreWithReservationDto convertToDtoChambreWithReservation(ChambreEntity chambre){
        ChambreWithReservationDto chambreDto = new ChambreWithReservationDto();
        chambreDto.setChambreId(chambre.getChambreId());
        chambreDto.setNumero(chambre.getNumero());
        chambreDto.setType(chambre.getType());
        chambreDto.setPrixNuit(chambre.getPrixNuit());
        chambreDto.setDisponible(chambre.getDisponible());
        if(chambre.getReservations() != null){
            List<ReservationByChambreDto> reservation = chambre.getReservations()
                    .stream()
                    .map(ReservationConverterDto::convertToDtoReservationByChambre)
                    .toList();
            chambreDto.setReservations(reservation);
        }
        if(chambre.getChambreServices() != null){
            List<ChambreServiceByChambreDto> cs = chambre.getChambreServices()
                    .stream()
                    .map(ChambreServiceConverterDto::convertToDtoChambreServiceByChambre)
                    .toList();
            chambreDto.setServices(cs);
        }
        return chambreDto;
    }

}
