package com.epita.spring.tphotelmanagement.exposition.dto.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientIdDto {

    @NotNull(message = "{validation.clientIdDto.clientID.NotNull.message}")
    protected Long clientId;
}
