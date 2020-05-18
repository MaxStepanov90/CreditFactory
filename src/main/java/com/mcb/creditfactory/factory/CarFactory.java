package com.mcb.creditfactory.factory;

import com.mcb.creditfactory.service.collateral.CollateralCarService;

public class CarFactory implements CollateralObjectFactory {

    private final CollateralCarService carService;

    public CarFactory(CollateralCarService carService) {
        this.carService = carService;
    }

    @Override
    public CollateralObjectService createObjectService() {
        return carService;
    }
}
