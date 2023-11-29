package com.epita.spring.tphotelmanagement.exposition.dto.reservation;

import com.epita.spring.tphotelmanagement.domaine.ReservationEntity;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientConverterDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationConverterDto {

    public static ReservationByClientDto convertToDtoReservationByClient(ReservationEntity r){
        ReservationByClientDto rDto = new ReservationByClientDto();
        rDto.setReservationId(r.getReservationId());
        rDto.setDateDebut(r.getDateDebut());
        rDto.setDateFin(r.getDateFin());
        if(r.getChambre() != null) {
            rDto.setChambre(ChambreConverterDto.convertToDtoChambre(r.getChambre()));
        }
        return rDto;
    }

    public static ReservationByChambreDto convertToDtoReservationByChambre(ReservationEntity r){
        ReservationByChambreDto rDto = new ReservationByChambreDto();
        rDto.setReservationId(r.getReservationId());
        rDto.setDateDebut(r.getDateDebut());
        rDto.setDateFin(r.getDateFin());
        if(r.getClient() != null){
            rDto.setClient(ClientConverterDto.convertToDtoClient(r.getClient()));
        }
        return rDto;
    }

    public static ReservationGetClientGetChambreDto convertToDtoFullReservation(ReservationEntity r){
        ReservationGetClientGetChambreDto rDto = new ReservationGetClientGetChambreDto();
        rDto.setReservationId(r.getReservationId());
        rDto.setDateDebut(r.getDateDebut());
        rDto.setDateFin(r.getDateFin());
        if(r.getClient() != null){
            rDto.setClient(ClientConverterDto.convertToDtoClient(r.getClient()));
        }
        if(r.getChambre() != null) {
            rDto.setChambre(ChambreConverterDto.convertToDtoChambre(r.getChambre()));
        }
        return rDto;
    }



}
