package com.epita.spring.tphotelmanagement.infrastructure;

import com.epita.spring.tphotelmanagement.domaine.ChambreServiceEntity;
import com.epita.spring.tphotelmanagement.domaine.ChambreServiceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChambreServiceRepository extends JpaRepository<ChambreServiceEntity, ChambreServiceId> {

}
