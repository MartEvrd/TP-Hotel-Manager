package com.epita.spring.tphotelmanagement.exposition.dto.client;

import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationByClientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientWithReservationDto extends ClientDto {
    protected List<ReservationByClientDto> reservations;

}