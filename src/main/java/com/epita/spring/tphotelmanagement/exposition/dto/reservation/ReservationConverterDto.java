package com.epita.spring.tphotelmanagement.exposition.dto.reservation;

import com.epita.spring.tphotelmanagement.domaine.ChambreEntity;
import com.epita.spring.tphotelmanagement.domaine.ClientEntity;
import com.epita.spring.tphotelmanagement.domaine.ReservationEntity;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationConverterDto {



    public static ReservationEntity convertToEntityResGetClientGetChambreDto(ReservationGetClientGetChambreDto rDto){
        ReservationEntity reservation = new ReservationEntity();
        ClientEntity client = new ClientEntity();
        ChambreEntity chambre = new ChambreEntity();
        reservation.setDateDebut(rDto.getDateDebut());
        reservation.setDateFin(rDto.getDateFin());

        client.setNom(rDto.getClient().getNom());
        client.setPrenom(rDto.getClient().getPrenom());
        client.setClientId(rDto.getClient().getClientId());
        client.setEmail(rDto.getClient().getEmail());
        client.setTelephone(rDto.getClient().getTelephone());

        chambre.setNumero(rDto.getChambre().getNumero());
        chambre.setDisponible(rDto.getChambre().getDisponible());
        chambre.setChambreId(rDto.getChambre().getChambreId());
        chambre.setPrixNuit(rDto.getChambre().getPrixNuit());
        chambre.setType(rDto.getChambre().getType());

        reservation.setClient(client);
        reservation.setChambre(chambre);
        return reservation;
    }

    public static ReservationGetClientGetChambreDto convertToDtoFullReservationIdDto(ReservationClientIdChambreIdDto rDto, ClientDto cDto, ChambreDto chDto){
        ReservationGetClientGetChambreDto rCompleteDto = new ReservationGetClientGetChambreDto();
        rCompleteDto.setDateDebut(rDto.getDateDebut());
        rCompleteDto.setDateFin(rDto.getDateFin());
        rCompleteDto.setClient(cDto);
        rCompleteDto.setChambre(chDto);
        return rCompleteDto;
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
