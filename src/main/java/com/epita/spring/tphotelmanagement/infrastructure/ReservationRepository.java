package com.epita.spring.tphotelmanagement.infrastructure;

import com.epita.spring.tphotelmanagement.domaine.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

}
