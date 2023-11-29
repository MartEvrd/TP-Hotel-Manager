package com.epita.spring.tphotelmanagement.exposition.dto.client;

import com.epita.spring.tphotelmanagement.domaine.ClientEntity;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationByClientDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationConverterDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientConverterDto {

    // Conversion d'un client standard en client sans réservation
    public static ClientDto convertToDtoClient(ClientEntity client){
        ClientDto cDto = new ClientDto();
        cDto.setClientId(client.getClientId());
        cDto.setNom(client.getNom());
        cDto.setPrenom(client.getPrenom());
        cDto.setEmail(client.getEmail());
        cDto.setTelephone(client.getTelephone());
        return cDto;
    }

    public static ClientWithReservationDto convertToDtoClientWithReservation(ClientEntity client){
        ClientWithReservationDto cDto = new ClientWithReservationDto();
        cDto.setClientId(client.getClientId());
        cDto.setNom(client.getNom());
        cDto.setPrenom(client.getPrenom());
        cDto.setEmail(client.getEmail());
        cDto.setTelephone(client.getTelephone());
        if(client.getReservations() != null){
            List<ReservationByClientDto> reservation = client.getReservations()
                    .stream()
                    .map(ReservationConverterDto::convertToDtoReservationByClient)
                    .toList();
            cDto.setReservations(reservation);
        }
        return cDto;
    }

}
