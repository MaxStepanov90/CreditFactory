package com.mcb.creditfactory.service.rating;

import com.mcb.creditfactory.model.CarRating;
import com.mcb.creditfactory.repository.CarRatingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class CarRatingServiceImplTest {

    @Mock
    private CarRatingRepository carRatingRepository;
    @InjectMocks
    private CarRatingServiceImpl carRatingService;

    @Test
    void findMaxDateRating_By_CarId_Should_Return_CarRating() {
        CarRating carRating = new CarRating();
        carRating.setCarId((long) 1);
        when(carRatingRepository.findMaxDateRatingByCarId((long) 1)).thenReturn(carRating);
        CarRating carRatingFromDb = carRatingService.findMaxDateRatingByCarId((long) 1);
        assertNotNull(carRatingFromDb);
        verify(carRatingRepository, times(1)).findMaxDateRatingByCarId((long) 1);
    }

    @Test
    void findMaxDateRating_By_CarId_Should_Return_Null() {
        when(carRatingRepository.findMaxDateRatingByCarId(null)).thenReturn(null);
        assertNull(carRatingService.findMaxDateRatingByCarId(null));
        verify(carRatingRepository, times(1)).findMaxDateRatingByCarId(null);
    }
}