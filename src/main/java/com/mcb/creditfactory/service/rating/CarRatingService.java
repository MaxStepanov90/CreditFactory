package com.mcb.creditfactory.service.rating;

import com.mcb.creditfactory.model.CarRating;

public interface CarRatingService {

    CarRating findMaxDateRatingByCarId(Long id);
}
