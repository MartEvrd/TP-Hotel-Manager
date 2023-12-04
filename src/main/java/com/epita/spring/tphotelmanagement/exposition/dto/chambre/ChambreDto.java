package com.epita.spring.tphotelmanagement.exposition.dto.chambre;

import com.epita.spring.tphotelmanagement.domaine.enums.TypeChambreEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChambreDto {
    protected Long chambreId;

    @NotNull(message = "{validation.chambreDto.numero.NotNull.message}")
    @NotBlank(message = "{validation.chambreDto.numero.NotBlank.message}")
    protected String numero;

    @NotNull(message = "{validation.chambreDto.type.NotNull.message}")
    protected TypeChambreEnum type;

    @NotNull(message = "{validation.chambreDto.prixNuit.NotNull.message}")
    @PositiveOrZero(message = "{validation.chambreDto.prixNuit.PositiveOrZero.message}")
    protected Double prixNuit;

    @NotNull(message = "{validation.chambreDto.disponible.NotNull.message}")
    protected Boolean disponible;
}
