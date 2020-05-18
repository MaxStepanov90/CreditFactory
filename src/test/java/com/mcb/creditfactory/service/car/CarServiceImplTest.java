package com.mcb.creditfactory.service.car;


import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.model.CarRating;
import com.mcb.creditfactory.service.rating.CarRatingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class CarServiceImplTest {

    @Mock
    private CarRatingService ratingService;

    @Test
    void getDateRating_Should_Set_Rating_Fields(){
        CarDto carDto = new CarDto();
        carDto.setId((long) 1);
        CarRating carRating = new CarRating();
        carRating.setCarId((long) 1);
        carRating.setValue(BigDecimal.valueOf(12000000));
        when(ratingService.findMaxDateRatingByCarId((long) 1)).thenReturn(carRating);
        CarRating foundRating = ratingService.findMaxDateRatingByCarId(carDto.getId());
        carDto.setValue(foundRating.getValue());
        assertEquals(carDto.getId(),carRating.getCarId());
        assertEquals(carDto.getValue(),foundRating.getValue());
        verify(ratingService, times(1)).findMaxDateRatingByCarId((long) 1);

    }
}