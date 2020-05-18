package com.mcb.creditfactory.factory;

import com.mcb.creditfactory.service.collateral.CollateralAirPlaneService;

public class AirPlaneFactory implements CollateralObjectFactory {

    private final CollateralAirPlaneService airPlaneService;

    public AirPlaneFactory(CollateralAirPlaneService airPlaneService) {
        this.airPlaneService = airPlaneService;
    }

    @Override
    public CollateralObjectService createObjectService() {
        return airPlaneService;
    }
}
