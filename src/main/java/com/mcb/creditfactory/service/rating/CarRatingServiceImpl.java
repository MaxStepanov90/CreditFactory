package com.mcb.creditfactory.service.rating;

import com.mcb.creditfactory.model.CarRating;
import com.mcb.creditfactory.repository.CarRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarRatingServiceImpl implements CarRatingService {

    private final CarRatingRepository carRatingRepository;

    @Autowired
    public CarRatingServiceImpl(CarRatingRepository carRatingRepository) {
        this.carRatingRepository = carRatingRepository;
    }

    public CarRating findMaxDateRatingByCarId(Long id) {
       return carRatingRepository.findMaxDateRatingByCarId(id);
    }

}
