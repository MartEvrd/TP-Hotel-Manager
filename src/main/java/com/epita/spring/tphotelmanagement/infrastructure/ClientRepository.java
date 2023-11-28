package com.epita.spring.tphotelmanagement.infrastructure;

import com.epita.spring.tphotelmanagement.domaine.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

}
