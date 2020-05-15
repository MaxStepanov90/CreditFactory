package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.model.CarRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRatingRepository extends JpaRepository<CarRating, Long> {

    @Query("From CarRating r WHERE r.carId=:id and r.dateOfEvaluation = " +
            "(select MAX(r.dateOfEvaluation) from CarRating r WHERE r.carId=:id)")
    CarRating findRatingByCarIdMaxDate(Long id);
}