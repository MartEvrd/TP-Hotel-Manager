package com.epita.spring.tphotelmanagement.domaine;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ChambreServiceId implements Serializable {
    private Long chambreId;
    private Long serviceId;
}
