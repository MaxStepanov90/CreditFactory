package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.factory.AirPlaneFactory;
import com.mcb.creditfactory.factory.CarFactory;
import com.mcb.creditfactory.factory.CollateralObjectFactory;
import com.mcb.creditfactory.factory.CollateralObjectService;
import com.mcb.creditfactory.service.collateral.CollateralAirPlaneService;
import com.mcb.creditfactory.service.collateral.CollateralCarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CollateralService {

    private final CollateralCarService carService;
    private final CollateralAirPlaneService airPlaneService;

    @Autowired
    public CollateralService(CollateralCarService carService, CollateralAirPlaneService airPlaneService) {
        this.carService = carService;
        this.airPlaneService = airPlaneService;
    }

    @SuppressWarnings("ConstantConditions")

    public Long saveCollateral(Collateral object) {
        return createServiceByInstance(object).saveCollateral(object);
    }

    public Collateral getInfo(Collateral object) {
        return createServiceByInstance(object).getInfo(object);
    }

    public CollateralObjectService createServiceByInstance(Collateral object){
        CollateralObjectFactory factory = createFactoryByInstance(object);
        return factory.createObjectService();
    }

    public CollateralObjectFactory createFactoryByInstance(Collateral object) {
        if (object instanceof CarDto) {
            return new CarFactory(carService);
        } else if (object instanceof AirPlaneDto) {
            return new AirPlaneFactory(airPlaneService);
        }
        throw new RuntimeException("Не поддерживаемый тип объекта: " + object);
    }
}
