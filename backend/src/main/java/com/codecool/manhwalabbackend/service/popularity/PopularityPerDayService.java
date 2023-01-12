package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.repository.date.StartDateOfViewCountsRepository;
import com.codecool.manhwalabbackend.repository.popularity.PopularityPerDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PopularityPerDayService {

    private final PopularityPerDayRepository popularityPerDayRepository;
    private final StartDateOfViewCountsRepository startDateOfViewCountsRepository;

    public void nullifyDailyViews(Long id){
        Long idOfStartTimes = 1L;
        LocalDateTime startDate = startDateOfViewCountsRepository.getStartDateOfViewCountsById(idOfStartTimes).getStartDateOfDailyViews();
        LocalDateTime currentDate = LocalDateTime.now();
        int oneDay = 1;
        Duration durationOfOneDay = Duration.ofDays(oneDay);
        Duration durationFromStartDate = Duration.between(startDate, currentDate);
        int equalTime = 0;
        if(durationFromStartDate.compareTo(durationOfOneDay) > equalTime) {
            popularityPerDayRepository.nullifyDailyViews(id);
        }
    }
}
