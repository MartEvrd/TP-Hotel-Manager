package com.epita.spring.tphotelmanagement.exposition.dto.chambre_service;

import com.epita.spring.tphotelmanagement.domaine.ChambreServiceId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChambreServiceDto {
    protected LocalDate date;
    protected LocalTime heure;
    protected String commentaire;
}
