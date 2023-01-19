package com.codecool.manhwalabbackend.service.popularity;

import com.codecool.manhwalabbackend.model.DTO.ComicProfileDTO;
import com.codecool.manhwalabbackend.model.popularity.ComicPopularityPerDay;
import com.codecool.manhwalabbackend.repository.ComicProfileRepository;
import com.codecool.manhwalabbackend.repository.popularity.PopularityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PopularityService {

    private final PopularityRepository popularityRepository;
    private final ComicProfileRepository comicProfileRepository;
    private final PopularityUtility popularityUtility;
    private final FirstAndLastDaysOfTimePeriod firstAndLastDaysOfTimePeriod;


    public List<ComicProfileDTO> getDailyTopFiveComic(){
        Pageable pageable = getPageable();
        return getDailyManhwaProfileDTOS(pageable);
    }

    private List<ComicProfileDTO> getDailyManhwaProfileDTOS(Pageable pageable) {
        List<ComicProfileDTO> topFiveManhwaToday = new ArrayList<>();
        for (ComicPopularityPerDay comicPopularityPerDay : popularityRepository
                .getComicPopularityPerDaysByDate(LocalDate.now(), pageable)) {

            Long comicId = comicPopularityPerDay.getComicId();
            popularityUtility.comicProfileDtoBuilder(topFiveManhwaToday, comicId, comicProfileRepository);
        }
        return topFiveManhwaToday;
    }

    public List<ComicProfileDTO> getWeeklyTopFiveComic(){
        return getWeeklyManhwaProfileDTOS();
    }

    private List<ComicProfileDTO> getWeeklyManhwaProfileDTOS() {
        return getManhwaProfileDTOSBetweenDates(firstAndLastDaysOfTimePeriod.getStartOfWeek(), firstAndLastDaysOfTimePeriod.getEndOfWeek());
    }

    public List<ComicProfileDTO> getMonthlyTopFiveComic(){
        return getMonthlyManhwaProfileDTOS();
    }

    private List<ComicProfileDTO> getMonthlyManhwaProfileDTOS() {
        return getManhwaProfileDTOSBetweenDates( firstAndLastDaysOfTimePeriod.getFirstDayOfMonth(), firstAndLastDaysOfTimePeriod.getLastDayOfMonth());
    }

    private List<ComicProfileDTO> getManhwaProfileDTOSBetweenDates(LocalDate startDate, LocalDate endDate) {
        List<ComicProfileDTO> topFiveManhwaToday = new ArrayList<>();
        int limit = 5;

        for (ComicPopularityPerDay comicPopularityPerDay : popularityRepository.getComicPopularityPerDaysBetweenDates(startDate, endDate, limit)) {

            Long comicId = comicPopularityPerDay.getComicId();
            popularityUtility.comicProfileDtoBuilder(topFiveManhwaToday, comicId, comicProfileRepository);
        }
        return topFiveManhwaToday;
    }

    private Pageable getPageable() {
        Sort sort = Sort.by(Sort.Direction.DESC, "viewsThisDay");
//        change magic numbers
        return PageRequest.of(0, 5, sort);
    }

    @Transactional
    public void updateDailyViewForComic(Long comicId, LocalDate date){
        try {
            ComicPopularityPerDay currentComicPopularityPerDay = popularityRepository.getComicPopularityPerDayByComicIdAndDate(comicId, date);
            Integer currentDailyViews = currentComicPopularityPerDay.getViewsThisDay();
            currentComicPopularityPerDay.setViewsThisDay(currentDailyViews + 1);
        }catch (NullPointerException e) {
            popularityRepository.save(new ComicPopularityPerDay(popularityRepository.findTopByOrderByIdDesc().getId()+1, comicId, 1, LocalDate.now()));
        }
    }


}
