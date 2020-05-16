package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.model.CarRating;
import com.mcb.creditfactory.repository.CarRepository;
import com.mcb.creditfactory.service.rating.CarRatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CarServiceImpl implements CarService {

    private final ExternalApproveService approveService;
    private final CarRepository carRepository;
    private final CarRatingService carRatingService;

    @Autowired
    public CarServiceImpl(ExternalApproveService approveService, CarRepository carRepository,
                          CarRatingService carRatingService) {
        this.approveService = approveService;
        this.carRepository = carRepository;
        this.carRatingService = carRatingService;
    }

    @Override
    public CarDto getDateRating(CarDto dto) {
        CarRating foundRating = carRatingService.findMaxDateRatingByCarId(dto.getId());
        if (foundRating != null) {
            dto.setValue(foundRating.getValue());
            dto.setAssessDate(foundRating.getDateOfEvaluation());
            log.info("carDto with id: {} setValue: {} setAssessDate: {} of carRating with id: {} with latest date: {}",
                    dto.getId(), dto.getValue(), dto.getAssessDate(), foundRating.getId(), foundRating.getDateOfEvaluation());
        } else {
            log.info("foundRating with car_id: {} not exist", dto.getId());
        }
        return dto;
    }

    @Override
    public boolean approve(CarDto dto) {
        return approveService.approve(new CarAdapter(dto)) == 0;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> load(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car fromDto(CarDto dto) {
        return Car.builder()
                .id(dto.getId())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .power(dto.getPower())
                .year(dto.getYear())
                .build();
    }

    @Override
    public CarDto toDTO(Car car) {
        CarRating foundRating = carRatingService.findMaxDateRatingByCarId(car.getId());
        return CarDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .model(car.getModel())
                .power(car.getPower())
                .year(car.getYear())
                .assessDate(foundRating.getDateOfEvaluation())
                .value(foundRating.getValue())
                .build();
    }

    @Override
    public Long getId(Car car) {
        return car.getId();
    }
}
