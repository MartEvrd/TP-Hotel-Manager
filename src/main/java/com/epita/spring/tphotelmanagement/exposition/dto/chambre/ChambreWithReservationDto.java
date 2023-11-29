package com.epita.spring.tphotelmanagement.exposition.dto.chambre;

import com.epita.spring.tphotelmanagement.exposition.dto.chambre_service.ChambreServiceByChambreDto;
import com.epita.spring.tphotelmanagement.exposition.dto.reservation.ReservationByChambreDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ChambreWithReservationDto extends ChambreDto {
    protected List<ReservationByChambreDto> reservations;
    protected List<ChambreServiceByChambreDto> services;
}
