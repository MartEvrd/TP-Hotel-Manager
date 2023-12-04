package com.epita.spring.tphotelmanagement.exposition.dto.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    protected Long clientId;

    @NotNull(message = "{validation.clientDto.nom.NotNull.message}")
    @NotBlank(message="{validation.clientDto.nom.NotBlank.message}")
    protected String nom;

    @NotNull(message = "{validation.clientDto.prenom.NotNull.message}")
    @NotBlank(message="{validation.clientDto.prenom.NotBlank.message}")
    protected String prenom;

    @NotNull(message = "{validation.clientDto.email.NotNull.message}")
    @NotBlank(message="{validation.clientDto.email.NotBlank.message}")
    protected String email;

    protected String telephone;

}
