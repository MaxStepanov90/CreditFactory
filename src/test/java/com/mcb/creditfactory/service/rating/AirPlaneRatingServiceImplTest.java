package com.mcb.creditfactory.service.rating;

import com.mcb.creditfactory.model.AirPlaneRating;
import com.mcb.creditfactory.model.CarRating;
import com.mcb.creditfactory.repository.AirPlaneRatingRepository;
import com.mcb.creditfactory.repository.CarRatingRepository;
import com.mcb.creditfactory.service.airplane.AirPlaneServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class AirPlaneRatingServiceImplTest {
    @Mock
    private AirPlaneRatingRepository airPlaneRatingRepository;
    @InjectMocks
    private AirPlaneRatingServiceImpl airPlaneRatingService;

    @Test
    void findMaxDateRating_By_AirPlaneId_Should_Return_CarRating() {
        AirPlaneRating airPlaneRating = new AirPlaneRating();
        airPlaneRating.setAirPlaneId((long) 1);
        when(airPlaneRatingRepository.findMaxDateRatingByAirPlaneId((long) 1)).thenReturn(airPlaneRating);
        AirPlaneRating airPlaneRatingFromDb = airPlaneRatingService.findMaxDateRatingByAirPlaneId((long) 1);
        assertNotNull(airPlaneRatingFromDb);
        verify(airPlaneRatingRepository, times(1)).findMaxDateRatingByAirPlaneId((long) 1);
    }

    @Test
    void findMaxDateRating_By_AirPlaneId_Should_Return_Null() {
        when(airPlaneRatingRepository.findMaxDateRatingByAirPlaneId(null)).thenReturn(null);
        assertNull(airPlaneRatingService.findMaxDateRatingByAirPlaneId(null));
        verify(airPlaneRatingRepository, times(1)).findMaxDateRatingByAirPlaneId(null);
    }
}