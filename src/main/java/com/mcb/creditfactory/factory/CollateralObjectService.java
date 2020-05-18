package com.mcb.creditfactory.factory;

import com.mcb.creditfactory.dto.Collateral;

public interface CollateralObjectService {

    Long saveCollateral(Collateral object);
    Collateral getInfo(Collateral object);
}
