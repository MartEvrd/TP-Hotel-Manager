package com.epita.spring.tphotelmanagement.infrastructure;

import com.epita.spring.tphotelmanagement.domaine.ChambreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreRepository extends JpaRepository<ChambreEntity, Long> {
    boolean existsByNumero(String numero);
}
