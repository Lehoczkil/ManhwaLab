package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.repository.date.StartDateOfViewCountsRepository;
import com.codecool.manhwalabbackend.repository.popularity.PopularityPerWeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PopularityPerWeekService {

    private final PopularityPerWeekRepository popularityPerWeekRepository;
    private final StartDateOfViewCountsRepository startDateOfViewCountsRepository;


    public void nullifyWeeklyViews(Long id){

        Long idOfStartTimes = 1L;
        LocalDateTime startDate = startDateOfViewCountsRepository.getStartDateOfViewCountsById(idOfStartTimes).getStartDateOfWeeklyViews();
        LocalDateTime currentDate = LocalDateTime.now();
        int sevenDay = 7;
        Duration durationOfOneDay = Duration.ofDays(sevenDay);
        Duration durationFromStartDate = Duration.between(startDate, currentDate);
        int equalTime = 0;
        if(durationFromStartDate.compareTo(durationOfOneDay) > equalTime) {
            popularityPerWeekRepository.nullifyWeeklyViews(id);
        }
    }
}
