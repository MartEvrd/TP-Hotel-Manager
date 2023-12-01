package com.epita.spring.tphotelmanagement.exposition.dto.client;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    protected Long clientId;

    @NotBlank(message = "{validation.clientDto.nom.NotNull.message}")
    protected String nom;

    @NotBlank(message = "{validation.clientDto.prenom.NotNull.message}")
    protected String prenom;

    @NotBlank(message = "{validation.clientDto.email.NotNull.message}")
    protected String email;

    protected String telephone;

}
