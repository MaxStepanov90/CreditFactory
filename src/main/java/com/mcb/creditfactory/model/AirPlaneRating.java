package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "AIRPLANE_RATING")
public class AirPlaneRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate dateOfEvaluation;
    @Column(name = "assessed_value")
    private BigDecimal value;
    @Column(name = "airplane_id")
    private Long airPlaneId;
}
