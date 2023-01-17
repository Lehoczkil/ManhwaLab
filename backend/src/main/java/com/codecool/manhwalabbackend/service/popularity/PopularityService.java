package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.model.DTO.ManhwaProfileDTO;
import com.codecool.manhwalabbackend.model.popularity.ComicPopularityPerDay;
import com.codecool.manhwalabbackend.repository.ManhwaProfileRepository;
import com.codecool.manhwalabbackend.repository.popularity.PopularityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PopularityService {

    private final PopularityRepository popularityRepository;
    private final ManhwaProfileRepository manhwaProfileRepository;
    private final PopularityUtility popularityUtility;


    public List<ManhwaProfileDTO> getDailyTopFiveComic(){
        Pageable pageable = getPageable();
        return getDailyManhwaProfileDTOS(pageable);
    }

    private List<ManhwaProfileDTO> getDailyManhwaProfileDTOS(Pageable pageable) {
        List<ManhwaProfileDTO> topFiveManhwaToday = new ArrayList<>();
        for (ComicPopularityPerDay comicPopularityPerDay : popularityRepository
                .getComicPopularityPerDaysByDate(LocalDate.now(), pageable)) {

            Long comicId = comicPopularityPerDay.getComicId();
            popularityUtility.manhwaProfileDtoBuilder(topFiveManhwaToday, comicId, manhwaProfileRepository);
        }
        return topFiveManhwaToday;
    }

    public List<ManhwaProfileDTO> getWeeklyTopFiveComic(){
//        change magic numbers
        Pageable pageable = getPageable();
        return getWeeklyManhwaProfileDTOS(pageable);
    }

    private List<ManhwaProfileDTO> getWeeklyManhwaProfileDTOS(Pageable pageable) {
        return getManhwaProfileDTOSBetweenDates(pageable, LocalDate.parse("2023-01-16"), LocalDate.parse("2023-01-23"));
    }

    public List<ManhwaProfileDTO> getMonthlyTopFiveComic(){
//        change magic numbers
        Pageable pageable = getPageable();
        return getMonthlyManhwaProfileDTOS(pageable);
    }

    private List<ManhwaProfileDTO> getMonthlyManhwaProfileDTOS(Pageable pageable) {
        return getManhwaProfileDTOSBetweenDates(pageable, LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-30"));
    }

    private List<ManhwaProfileDTO> getManhwaProfileDTOSBetweenDates(Pageable pageable, LocalDate startDate, LocalDate endDate) {
        List<ManhwaProfileDTO> topFiveManhwaToday = new ArrayList<>();
        for (ComicPopularityPerDay comicPopularityPerDay : popularityRepository
                .getComicPopularityPerDaysByDateBetween(startDate, endDate, pageable)) {

            Long comicId = comicPopularityPerDay.getComicId();
            popularityUtility.manhwaProfileDtoBuilder(topFiveManhwaToday, comicId, manhwaProfileRepository);
        }
        return topFiveManhwaToday;
    }

    private Pageable getPageable() {
        Sort sort = Sort.by(Sort.Direction.DESC, "viewsThisDay");
//        change magic numbers
        Pageable pageable = PageRequest.of(0, 5, sort);
        return pageable;
    }
}