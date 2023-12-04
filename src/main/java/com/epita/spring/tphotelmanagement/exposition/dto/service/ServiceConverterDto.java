package com.epita.spring.tphotelmanagement.exposition.dto.service;

import com.epita.spring.tphotelmanagement.domaine.ServiceEntity;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre_service.ChambreServiceByServciceDto;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre_service.ChambreServiceConverterDto;

import java.util.List;

public class ServiceConverterDto{


    public static ServiceEntity convertToEntityServiceDto(ServiceDto sDto){
        ServiceEntity s = new ServiceEntity(
                sDto.getNom(),
                sDto.getDescription(),
                sDto.getTarif()
        );
        return s;
    }

    public static ServiceDto convertToDtoService(ServiceEntity s){
        ServiceDto sDto = new ServiceDto();
        sDto.setServiceId(s.getServiceId());
        sDto.setNom(s.getNom());
        sDto.setDescription(s.getDescription());
        sDto.setTarif(s.getTarif());
        return sDto;
    }

    public static ServiceWithChambreServiceByServiceDto convertToDtoServiceWithChambreServiceByService(ServiceEntity s){
        ServiceWithChambreServiceByServiceDto sDto = new ServiceWithChambreServiceByServiceDto();
        sDto.setServiceId(s.getServiceId());
        sDto.setNom(s.getNom());
        sDto.setDescription(s.getDescription());
        sDto.setTarif(s.getTarif());
        if(s.getChambreServices() != null){
            List<ChambreServiceByServciceDto> csDto = s.getChambreServices()
                    .stream()
                    .map(ChambreServiceConverterDto::convertToDtoChambreServiceByService)
                    .toList();
            sDto.setChambreServices(csDto);
        }
        return sDto;
    }






}
