package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.model.date.StartDateOfViewCounting;
import com.codecool.manhwalabbackend.repository.date.StartDateOfViewCountsRepository;
import com.codecool.manhwalabbackend.repository.popularity.PopularityPerMonthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

@Service
@RequiredArgsConstructor
public class PopularityPerMonthService {

    private final PopularityPerMonthRepository popularityPerMonthRepository;
    private final StartDateOfViewCountsRepository startDateOfViewCountsRepository;


    public void nullifyMonthlyViews(Long id){
        Long idOfStartTimes = 1L;
        StartDateOfViewCounting data = startDateOfViewCountsRepository.getStartDateOfViewCountsById(idOfStartTimes);
        LocalDateTime startDate = data.getStartDateOfMonthlyViews();
        LocalDateTime currentDate = LocalDateTime.now();
        Month currentMonth = data.getCurrentMonth();
        int daysInMonth = currentMonth.length(false);
        Duration durationOfOneDay = Duration.ofDays(daysInMonth);
        Duration durationFromStartDate = Duration.between(startDate, currentDate);
        int equalTime = 0;
        if(durationFromStartDate.compareTo(durationOfOneDay) > equalTime) {
            popularityPerMonthRepository.nullifyMonthlyViews(id);
        }
    }
}
