package com.epita.spring.tphotelmanagement.exposition.dto.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDto {
    protected Long serviceId;
    protected String nom;
    protected String description;
    protected Double tarif;
}
