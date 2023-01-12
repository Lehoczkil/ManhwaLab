package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.model.DTO.ManhwaProfileDTO;
import com.codecool.manhwalabbackend.model.ManhwaProfile;
import com.codecool.manhwalabbackend.model.date.StartDateOfViewCounting;
import com.codecool.manhwalabbackend.model.popularity.ComicPopularityPerMonth;
import com.codecool.manhwalabbackend.repository.ManhwaProfileRepository;
import com.codecool.manhwalabbackend.repository.date.StartDateOfViewCountsRepository;
import com.codecool.manhwalabbackend.repository.popularity.PopularityPerMonthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PopularityPerMonthService {

    private final PopularityPerMonthRepository popularityPerMonthRepository;
    private final StartDateOfViewCountsRepository startDateOfViewCountsRepository;
    private final ManhwaProfileRepository manhwaProfileRepository;



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

    public List<ManhwaProfileDTO> getTopFiveMonthlyComic(){
        Sort sort = Sort.by(Sort.Direction.DESC, "viewsThisMonth");
        Pageable pageable = PageRequest.of(0, 5, sort);
        List<ManhwaProfileDTO> topFiveManhwaToday = new ArrayList<>();
        for (ComicPopularityPerMonth comicPopularityPerMonth : popularityPerMonthRepository.findAll(pageable).getContent()) {

            Long comicId = comicPopularityPerMonth.getComicId();
            ManhwaProfile manhwaProfileById = manhwaProfileRepository.getManhwaProfileById(comicId);
            String title = manhwaProfileById.getTitle();
            topFiveManhwaToday.add(new ManhwaProfileDTO(comicId, title));
        }
        return topFiveManhwaToday;

    }
}
