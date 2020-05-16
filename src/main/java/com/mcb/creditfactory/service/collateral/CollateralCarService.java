package com.mcb.creditfactory.service.collateral;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.factory.CollateralFactoryService;
import com.mcb.creditfactory.service.car.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CollateralCarService implements CollateralFactoryService {

    private final CarService service;

    @Autowired
    public CollateralCarService(CarService service) {
        this.service = service;
    }

    public Long saveCollateral(Collateral object) {
        CarDto dto = (CarDto) object;
        boolean approved = service.approve(service.getDateRating(dto));
        log.info("Approval status of carDto with id: {} status: {}", dto.getId(), approved);
        if (!approved) {
            return null;
        }
        return Optional.of(dto)
                .map(service::fromDto)
                .map(service::save)
                .map(service::getId)
                .orElse(null);
    }

    public Collateral getInfo(Collateral object) {
        return Optional.of((CarDto) object)
                .map(service::fromDto)
                .map(service::getId)
                .flatMap(service::load)
                .map(service::toDTO)
                .orElse(null);
    }

}
