package com.mcb.creditfactory.service;

import com.mcb.creditfactory.factory.CarFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class CollateralServiceTest {

    @InjectMocks
    CollateralService service;
    @Mock
    CarFactory carFactory;

    @Test
    void createFactoryByInstance(){

    }
}
// public CollateralFactoryService createServiceByInstance(Collateral object){
//        CollateralFactory factory = createFactoryByInstance(object);
//        return factory.createFactoryService();
//    }
//
//    public CollateralFactory createFactoryByInstance(Collateral object) {
//        if (object instanceof CarDto) {
//            return new CarFactory(carService);
//        } else if (object instanceof AirPlaneDto) {
//            return new AirPlaneFactory(airPlaneService);
//        }
//        throw new RuntimeException("Не поддерживаемый тип объекта: " + object);
//    }