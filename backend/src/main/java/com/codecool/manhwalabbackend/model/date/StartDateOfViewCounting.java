package com.codecool.manhwalabbackend.model.date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.Month;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StartDateOfViewCounting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private LocalDateTime startDateOfDailyViews;
    private LocalDateTime startDateOfWeeklyViews;
    private LocalDateTime startDateOfMonthlyViews;
    @Enumerated(EnumType.STRING)
    private Month currentMonth;
}
