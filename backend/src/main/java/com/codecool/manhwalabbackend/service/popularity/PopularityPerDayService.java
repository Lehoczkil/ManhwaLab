package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.model.DTO.ManhwaProfileDTO;
import com.codecool.manhwalabbackend.model.ManhwaProfile;
import com.codecool.manhwalabbackend.model.popularity.ComicPopularityPerDay;
import com.codecool.manhwalabbackend.repository.ManhwaProfileRepository;
import com.codecool.manhwalabbackend.repository.date.StartDateOfViewCountsRepository;
import com.codecool.manhwalabbackend.repository.popularity.PopularityPerDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PopularityPerDayService {

    private final PopularityPerDayRepository popularityPerDayRepository;
    private final StartDateOfViewCountsRepository startDateOfViewCountsRepository;
    private final ManhwaProfileRepository manhwaProfileRepository;

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

    public List<ManhwaProfileDTO> getTopFiveDailyComic(){
        Sort sort = Sort.by(Sort.Direction.DESC, "viewsThisDay");
        Pageable pageable = PageRequest.of(0, 5, sort);
        List<ManhwaProfileDTO> topFiveManhwaToday = new ArrayList<>();
        for (ComicPopularityPerDay comicPopularityPerDay : popularityPerDayRepository.findAll(pageable).getContent()) {

            Long comicId = comicPopularityPerDay.getComicId();
            ManhwaProfile manhwaProfileById = manhwaProfileRepository.getManhwaProfileById(comicId);
            String title = manhwaProfileById.getTitle();
            topFiveManhwaToday.add(new ManhwaProfileDTO(comicId, title));
        }
        return topFiveManhwaToday;

    }
}
