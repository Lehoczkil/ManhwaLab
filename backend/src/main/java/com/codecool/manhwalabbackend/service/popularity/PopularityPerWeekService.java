package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.model.DTO.ManhwaProfileDTO;
import com.codecool.manhwalabbackend.model.ManhwaProfile;
import com.codecool.manhwalabbackend.model.popularity.ComicPopularityPerWeek;
import com.codecool.manhwalabbackend.repository.ManhwaProfileRepository;
import com.codecool.manhwalabbackend.repository.date.StartDateOfViewCountsRepository;
import com.codecool.manhwalabbackend.repository.popularity.PopularityPerWeekRepository;
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
public class PopularityPerWeekService {

    private final PopularityPerWeekRepository popularityPerWeekRepository;
    private final StartDateOfViewCountsRepository startDateOfViewCountsRepository;
    private final ManhwaProfileRepository manhwaProfileRepository;



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

    public List<ManhwaProfileDTO> getTopFiveWeeklyComic(){
        Sort sort = Sort.by(Sort.Direction.DESC, "viewsThisWeek");
        Pageable pageable = PageRequest.of(0, 5, sort);
        List<ManhwaProfileDTO> topFiveManhwaToday = new ArrayList<>();
        for (ComicPopularityPerWeek comicPopularityPerWeek : popularityPerWeekRepository.findAll(pageable).getContent()) {

            Long comicId = comicPopularityPerWeek.getComicId();
            ManhwaProfile manhwaProfileById = manhwaProfileRepository.getManhwaProfileById(comicId);
            String title = manhwaProfileById.getTitle();
            topFiveManhwaToday.add(new ManhwaProfileDTO(comicId, title));
        }
        return topFiveManhwaToday;

    }
}
