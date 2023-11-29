package com.epita.spring.tphotelmanagement.infrastructure;

import com.epita.spring.tphotelmanagement.domaine.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
