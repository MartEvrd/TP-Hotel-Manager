package com.epita.spring.tphotelmanagement.exposition.dto.reservation;

import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
// Utilisation pour récupération de la réservation par la chambre (n'inclue pas l'objet chambre associé à la réservation)
public class ReservationByChambreDto extends ReservationDto {
    private ClientDto client;
}
