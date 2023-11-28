package com.epita.spring.tphotelmanagement.domaine;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long reservationId;

    @Column(nullable = false)
    private LocalDateTime dateDebut;

    @Column(nullable = false)
    private LocalDateTime dateFin;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private ClientEntity client;

    @ManyToOne
    @JoinColumn(name = "chambre_id")
    @JsonBackReference
    private ChambreEntity chambre;

    @CreatedDate
    @Column(nullable = false, updatable = false, name = "creation_date")
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false, name = "last_modification_date")
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime lastModifiedDate;

}
