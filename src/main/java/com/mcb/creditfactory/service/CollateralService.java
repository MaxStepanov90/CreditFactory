package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.service.airplane.AirPlaneService;
import com.mcb.creditfactory.service.car.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO: reimplement this
@Slf4j
@Service
public class CollateralService {

    private final CarService carService;
    private final AirPlaneService airPlaneService;

    @Autowired
    public CollateralService(CarService carService, AirPlaneService airPlaneService) {
        this.carService = carService;
        this.airPlaneService = airPlaneService;
    }

    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {

        if (object instanceof CarDto) {
            CarDto carDto = (CarDto) object;
            CarDto carCheckedDate = carService.checkDateRating(carDto);
            boolean approved = carService.approve(carCheckedDate);
            log.info("Approval status of carDto with id: {} status: {}", carCheckedDate.getId(), approved);
            if (!approved) {
                return null;
            }
            return Optional.of(carDto)
                    .map(carService::fromDto)
                    .map(carService::save)
                    .map(carService::getId)
                    .orElse(null);
        }
        if (object instanceof AirPlaneDto) {
            AirPlaneDto airPlaneDto = (AirPlaneDto) object;
            AirPlaneDto airPlaneCheckedDate = airPlaneService.checkDateRating(airPlaneDto);
            boolean approved = airPlaneService.approve(airPlaneCheckedDate);
            log.info("Approval status of airPlaneDto with id: {} status: {}", airPlaneCheckedDate.getId(), approved);
            if (!approved) {
                return null;
            }
            return Optional.of(airPlaneDto)
                    .map(airPlaneService::fromDto)
                    .map(airPlaneService::save)
                    .map(airPlaneService::getId)
                    .orElse(null);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Collateral getInfo(Collateral object) {

        if (object instanceof CarDto) {
            return Optional.of((CarDto) object)
                    .map(carService::fromDto)
                    .map(carService::getId)
                    .flatMap(carService::load)
                    .map(carService::toDTO)
                    .orElse(null);
        }
        if (object instanceof AirPlaneDto) {
            return Optional.of((AirPlaneDto) object)
                    .map(airPlaneService::fromDto)
                    .map(airPlaneService::getId)
                    .flatMap(airPlaneService::load)
                    .map(airPlaneService::toDTO)
                    .orElse(null);
        } else {
            throw new IllegalArgumentException();
        }
    }
}
