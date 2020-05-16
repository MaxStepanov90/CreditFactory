package com.mcb.creditfactory.factory;

import com.mcb.creditfactory.service.collateral.CollateralCarService;

public class CarFactory implements CollateralFactory {

    private final CollateralCarService carService;

    public CarFactory(CollateralCarService carService) {
        this.carService = carService;
    }

    @Override
    public CollateralFactoryService createFactoryService() {
        return carService;
    }
}
