package com.mcb.creditfactory.factory;

import com.mcb.creditfactory.service.collateral.CollateralAirPlaneService;

public class AirPlaneFactory implements CollateralFactory {

    private final CollateralAirPlaneService airPlaneService;

    public AirPlaneFactory(CollateralAirPlaneService airPlaneService) {
        this.airPlaneService = airPlaneService;
    }

    @Override
    public CollateralFactoryService createFactoryService() {
        return airPlaneService;
    }
}
