package com.mcb.creditfactory.service.collateral;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.factory.CollateralFactoryService;
import com.mcb.creditfactory.service.airplane.AirPlaneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class CollateralAirPlaneService implements CollateralFactoryService {

    private final AirPlaneService service;

    @Autowired
    public CollateralAirPlaneService(AirPlaneService service) {
        this.service = service;
    }

    @Override
    public Long saveCollateral(Collateral object) {
        AirPlaneDto dto = (AirPlaneDto) object;
        boolean approved = service.approve(service.getDateRating(dto));
        log.info("Approval status of airPlaneDto with id: {} status: {}", dto.getId(), approved);
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
        return Optional.of((AirPlaneDto) object)
                .map(service::fromDto)
                .map(service::getId)
                .flatMap(service::load)
                .map(service::toDTO)
                .orElse(null);
    }
}
