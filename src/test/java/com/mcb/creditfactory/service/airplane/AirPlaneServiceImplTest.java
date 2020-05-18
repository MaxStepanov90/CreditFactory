package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.model.AirPlaneRating;
import com.mcb.creditfactory.service.rating.AirPlaneRatingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class AirPlaneServiceImplTest {

    @Mock
    private AirPlaneRatingService ratingService;

    @Test
    void getDateRating_Should_Set_Rating_Fields() {
        AirPlaneDto dto = new AirPlaneDto();
        dto.setId((long) 1);
        AirPlaneRating rating = new AirPlaneRating();
        rating.setAirPlaneId((long) 1);
        rating.setValue(BigDecimal.valueOf(12000000));
        when(ratingService.findMaxDateRatingByAirPlaneId((long) 1)).thenReturn(rating);
        AirPlaneRating foundRating = ratingService.findMaxDateRatingByAirPlaneId(dto.getId());
        dto.setValue(foundRating.getValue());
        assertEquals(dto.getId(), rating.getAirPlaneId());
        assertEquals(dto.getValue(), foundRating.getValue());
        verify(ratingService, times(1)).findMaxDateRatingByAirPlaneId((long) 1);

    }
}