package com.epita.spring.tphotelmanagement.exposition.dto.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    protected Long reservationId;

    protected LocalDateTime dateDebut;

    protected LocalDateTime dateFin;
}
