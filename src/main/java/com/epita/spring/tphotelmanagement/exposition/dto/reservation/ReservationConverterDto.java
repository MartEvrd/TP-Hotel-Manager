package com.epita.spring.tphotelmanagement.exposition.dto.reservation;

import com.epita.spring.tphotelmanagement.domaine.ChambreEntity;
import com.epita.spring.tphotelmanagement.domaine.ClientEntity;
import com.epita.spring.tphotelmanagement.domaine.ReservationEntity;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientConverterDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationConverterDto {

    public static ReservationEntity convertToEntityResGetClientGetChambreDto(ReservationGetClientGetChambreDto reservationGetClientGetChambreDto){
        ReservationEntity reservation = new ReservationEntity();
        ClientEntity client = new ClientEntity();
        ChambreEntity chambre = new ChambreEntity();
        reservation.setDateDebut(reservationGetClientGetChambreDto.getDateDebut());
        reservation.setDateFin(reservationGetClientGetChambreDto.getDateFin());

        client.setNom(reservationGetClientGetChambreDto.getClient().getNom());
        client.setPrenom(reservationGetClientGetChambreDto.getClient().getPrenom());
        client.setClientId(reservationGetClientGetChambreDto.getClient().getClientId());
        client.setEmail(reservationGetClientGetChambreDto.getClient().getEmail());
        client.setTelephone(reservationGetClientGetChambreDto.getClient().getTelephone());

        chambre.setNumero(reservationGetClientGetChambreDto.getChambre().getNumero());
        chambre.setDisponible(reservationGetClientGetChambreDto.getChambre().getDisponible());
        chambre.setChambreId(reservationGetClientGetChambreDto.getChambre().getChambreId());
        chambre.setPrixNuit(reservationGetClientGetChambreDto.getChambre().getPrixNuit());
        chambre.setType(reservationGetClientGetChambreDto.getChambre().getType());

        reservation.setClient(client);
        reservation.setChambre(chambre);
        return reservation;
    }

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
