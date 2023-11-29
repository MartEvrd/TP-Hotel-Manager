package com.epita.spring.tphotelmanagement.exposition.dto.chambre_service;

import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChambreServiceByServciceDto extends ChambreServiceDto {
    protected ChambreDto chambre;
}
