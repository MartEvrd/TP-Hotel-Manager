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

    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    protected LocalDateTime dateDebut;

    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    protected LocalDateTime dateFin;
}
