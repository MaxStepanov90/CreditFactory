package com.mcb.creditfactory.service.rating;

import com.mcb.creditfactory.model.AirPlaneRating;

public interface AirPlaneRatingService {

    AirPlaneRating findMaxDateRatingByAirPlaneId(Long id);

}
