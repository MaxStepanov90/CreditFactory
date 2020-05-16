package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirPlaneDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.AirPlane;
import com.mcb.creditfactory.model.AirPlaneRating;
import com.mcb.creditfactory.repository.AirPlaneRepository;
import com.mcb.creditfactory.service.rating.AirPlaneRatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class AirPlaneServiceImpl implements AirPlaneService {

    private final ExternalApproveService approveService;
    private final AirPlaneRepository airPlaneRepository;
    private final AirPlaneRatingService airPlaneRatingService;

    @Autowired
    public AirPlaneServiceImpl(ExternalApproveService approveService,
                               AirPlaneRepository airPlaneRepository,
                               AirPlaneRatingService airPlaneRatingService) {
        this.approveService = approveService;
        this.airPlaneRepository = airPlaneRepository;
        this.airPlaneRatingService = airPlaneRatingService;
    }

    @Override
    public AirPlaneDto getDateRating(AirPlaneDto dto) {
        AirPlaneRating foundRating = airPlaneRatingService.findMaxDateRatingByAirPlaneId(dto.getId());
        dto.setValue(foundRating.getValue());
        dto.setAssessDate(foundRating.getDateOfEvaluation());
        log.info("airPlaneDto with id: {} setValue: {} setAssessDate: {} of airPlaneRating with id: {} with latest date: {}",
                dto.getId(), dto.getValue(), dto.getAssessDate(), foundRating.getId(), foundRating.getDateOfEvaluation());
        return dto;
    }

    @Override
    public boolean approve(AirPlaneDto dto) {
        return approveService.approve(new AirPlaneAdapter(dto)) == 0;
    }

    @Override
    public AirPlane save(AirPlane plane) {
        return airPlaneRepository.save(plane);
    }

    @Override
    public Optional<AirPlane> load(Long id) {
        return airPlaneRepository.findById(id);
    }

    @Override
    public AirPlane fromDto(AirPlaneDto dto) {
        return AirPlane.builder()
                .id(dto.getId())
                .brand(dto.getBrand())
                .model(dto.getModel())
                .manufacturer(dto.getManufacturer())
                .year(dto.getYear())
                .fuelCapacity(dto.getFuelCapacity())
                .seats(dto.getSeats())
                .build();
    }

    @Override
    public AirPlaneDto toDTO(AirPlane plane) {
        AirPlaneRating foundRating = airPlaneRatingService.findMaxDateRatingByAirPlaneId(plane.getId());
        return AirPlaneDto.builder()
                .id(plane.getId())
                .brand(plane.getBrand())
                .model(plane.getModel())
                .manufacturer(plane.getManufacturer())
                .year(plane.getYear())
                .fuelCapacity(plane.getFuelCapacity())
                .seats(plane.getSeats())
                .assessDate(foundRating.getDateOfEvaluation())
                .value(foundRating.getValue())
                .build();
    }

    @Override
    public Long getId(AirPlane plane) {
        return plane.getId();
    }
}
