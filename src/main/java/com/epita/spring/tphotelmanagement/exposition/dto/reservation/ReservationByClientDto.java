package com.epita.spring.tphotelmanagement.exposition.dto.reservation;

import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
// Utilisation pour récupération de la réservation par le client (n'inclue pas l'objet client associé à la réservation)
public class ReservationByClientDto extends ReservationDto {
    private ChambreDto chambre;
}
