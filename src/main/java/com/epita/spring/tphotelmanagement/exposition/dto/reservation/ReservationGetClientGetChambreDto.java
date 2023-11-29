package com.epita.spring.tphotelmanagement.exposition.dto.reservation;

import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
// Récupération de tous les attributs
public class ReservationGetClientGetChambreDto extends ReservationDto {
    protected ClientDto client;
    protected ChambreDto chambre;
}
