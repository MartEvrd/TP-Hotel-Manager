package com.epita.spring.tphotelmanagement.domaine;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "chambre_service")
public class ChambreServiceEntity {

    @EmbeddedId
    private ChambreServiceId id;

    @ManyToOne
    @MapsId("chambreId")
    private ChambreEntity chambre;

    @ManyToOne
    @MapsId("serviceId")
    private ServiceEntity service;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime heure;

    @Column(columnDefinition = "TEXT")
    private String commentaire;
}
