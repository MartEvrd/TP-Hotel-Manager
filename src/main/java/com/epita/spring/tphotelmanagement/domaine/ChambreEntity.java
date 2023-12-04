package com.epita.spring.tphotelmanagement.domaine;

import com.epita.spring.tphotelmanagement.domaine.enums.TypeChambreEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name = "chambre")
public class ChambreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Setter(AccessLevel.NONE)
    private Long chambreId;

    @Column(nullable = false, length = 4)
    private String numero;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeChambreEnum type;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,3)")
    private Double prixNuit;

    @Column(nullable = false)
    private Boolean disponible;

    @OneToMany(mappedBy = "chambre", cascade = CascadeType.REMOVE)
    private List<ReservationEntity> reservations;

    @CreatedDate
    @Column(nullable = false, updatable = false, name = "creation_date")
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false, name = "last_modification_date")
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime lastModifiedDate;

    @OneToMany(mappedBy = "chambre")
    private List<ChambreServiceEntity> chambreServices;

}
