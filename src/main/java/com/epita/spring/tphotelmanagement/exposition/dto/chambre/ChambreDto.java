package com.epita.spring.tphotelmanagement.exposition.dto.chambre;

import com.epita.spring.tphotelmanagement.domaine.enums.TypeChambreEnum;
import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChambreDto {
    protected Long chambreId;
    protected String numero;
    protected TypeChambreEnum type;
    protected Double prixNuit;
    protected Boolean disponible;
}
