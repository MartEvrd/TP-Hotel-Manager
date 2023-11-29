package com.epita.spring.tphotelmanagement.exposition.dto.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    protected Long clientId;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String telephone;

}
