package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.AirPlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPlaneRepository extends JpaRepository<AirPlane, Long> {
}
