package com.epita.spring.tphotelmanagement.exposition.dto.chambre;

import com.epita.spring.tphotelmanagement.domaine.enums.TypeChambreEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChambreIdDto {

    @NotNull(message = "{validation.chambreIdDto.chambreID.NotNull.message}")
    protected Long chambreId;
}
