package com.epita.spring.tphotelmanagement.exposition.dto.chambre_service;

import com.epita.spring.tphotelmanagement.exposition.dto.service.ServiceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChambreServiceByChambreDto extends ChambreServiceDto {
    protected ServiceDto service;
}
