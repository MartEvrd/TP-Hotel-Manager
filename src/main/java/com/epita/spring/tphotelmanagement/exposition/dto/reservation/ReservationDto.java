package com.epita.spring.tphotelmanagement.exposition.dto.reservation;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    protected Long reservationId;

    @NotNull(message = "{validation.reservationDto.dateDebut.NotNull.message}")
    @FutureOrPresent(message = "{validation.reservationDto.dateDebut.FutureOrPresent.message}")
    protected LocalDate dateDebut;

    @NotNull(message = "{validation.reservationDto.dateFin.NotNull.message}")
    @Future(message = "{validation.reservationDto.dateFin.Future.message}")
    protected LocalDate dateFin;
}