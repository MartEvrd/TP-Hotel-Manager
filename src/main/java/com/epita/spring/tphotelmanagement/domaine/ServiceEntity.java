package com.epita.spring.tphotelmanagement.domaine;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
@ToString(onlyExplicitlyIncluded = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "service")
public class ServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long serviceId;

    @Column(nullable = false, length = 100)
    private String nom;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "DECIMAL(10,3)")
    private Double tarif;

    @CreatedDate
    @Column(nullable = false, updatable = false, name = "creation_date")
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(nullable = false, name = "last_modification_date")
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss")
    private LocalDateTime lastModifiedDate;

    @OneToMany(mappedBy = "service")
    private List<ChambreServiceEntity> chambreServices;

    public ServiceEntity(String nom, String description, Double tarif) {
        this.nom = nom;
        this.description = description;
        this.tarif = tarif;
        this.chambreServices = new ArrayList<>();
    }
}
