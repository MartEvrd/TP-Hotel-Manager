package com.epita.spring.tphotelmanagement.exposition.dto.chambre_service;

import com.epita.spring.tphotelmanagement.domaine.ChambreServiceEntity;
import com.epita.spring.tphotelmanagement.exposition.dto.chambre.ChambreConverterDto;
import com.epita.spring.tphotelmanagement.exposition.dto.service.ServiceConverterDto;

public class ChambreServiceConverterDto {

    public static ChambreServiceDto convertToDtoChambreService(ChambreServiceEntity cs){
        ChambreServiceDto csDto = new ChambreServiceDto();
        csDto.setDate(cs.getDate());
        csDto.setHeure(cs.getHeure());
        csDto.setCommentaire(cs.getCommentaire());
        return csDto;
    }

    public static ChambreServiceByChambreDto convertToDtoChambreServiceByChambre(ChambreServiceEntity cs){
        ChambreServiceByChambreDto csDto = new ChambreServiceByChambreDto();
        csDto.setDate(cs.getDate());
        csDto.setHeure(cs.getHeure());
        csDto.setCommentaire(cs.getCommentaire());
        csDto.setService(ServiceConverterDto.convertToDtoService(cs.getService()));
        return csDto;
    }

    public static ChambreServiceByServciceDto convertToDtoChambreServiceByService(ChambreServiceEntity cs){
        ChambreServiceByServciceDto csDto = new ChambreServiceByServciceDto();
        csDto.setDate(cs.getDate());
        csDto.setHeure(cs.getHeure());
        csDto.setCommentaire(cs.getCommentaire());
        csDto.setChambre(ChambreConverterDto.convertToDtoChambre(cs.getChambre()));
        return csDto;
    }

}
