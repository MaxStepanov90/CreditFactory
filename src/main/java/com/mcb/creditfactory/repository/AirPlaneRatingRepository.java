package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.AirPlaneRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AirPlaneRatingRepository extends JpaRepository<AirPlaneRating, Long> {
    @Query("FROM AirPlaneRating r WHERE r.airPlaneId=:id AND r.dateOfEvaluation = " +
            "(SELECT MAX(r.dateOfEvaluation) FROM AirPlaneRating r WHERE r.airPlaneId=:id)")
    AirPlaneRating findMaxDateRatingByAirPlaneId(Long id);
}
