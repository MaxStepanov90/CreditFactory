package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
public class AirPlaneAdapter implements CollateralObject {

    private AirPlaneDto airPlane;

    @Override
    public BigDecimal getValue() {
        return airPlane.getValue();
    }

    @Override
    public Short getYear() {
        return airPlane.getYear();
    }

    @Override
    public LocalDate getDate() {
        return airPlane.getAssessDate();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}
