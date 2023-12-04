package com.epita.spring.tphotelmanagement.exposition.dto.reservation;

import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreIdDto;
import com.epita.spring.tphotelmanagement.exposition.dto.client.ClientIdDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
// Récupération de tous les attributs
public class ReservationClientIdChambreIdDto extends ReservationDto {
    @Valid protected ClientIdDto client;
    @Valid protected ChambreIdDto chambre;
}
