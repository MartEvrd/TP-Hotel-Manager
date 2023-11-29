package com.epita.spring.tphotelmanagement.exposition.dto.service;

import com.epita.spring.tphotelmanagement.exposition.dto.chambre_service.ChambreServiceByServciceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceWithChambreServiceByServiceDto extends ServiceDto {
    protected List<ChambreServiceByServciceDto> chambreServices;
}
