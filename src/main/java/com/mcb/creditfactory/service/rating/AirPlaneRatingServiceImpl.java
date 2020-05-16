package com.mcb.creditfactory.service.rating;

import com.mcb.creditfactory.model.AirPlaneRating;
import com.mcb.creditfactory.repository.AirPlaneRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirPlaneRatingServiceImpl implements AirPlaneRatingService {

    private final AirPlaneRatingRepository airPlaneRatingRepository;

    @Autowired
    public AirPlaneRatingServiceImpl(AirPlaneRatingRepository airPlaneRatingRepository) {
        this.airPlaneRatingRepository = airPlaneRatingRepository;
    }

    public AirPlaneRating findMaxDateRatingByAirPlaneId(Long id) {
       return airPlaneRatingRepository.findMaxDateRatingByAirPlaneId(id);

    }
}
