package com.codecool.manhwalabbackend.repository.popularity;

import com.codecool.manhwalabbackend.model.popularity.ComicPopularityPerDay;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PopularityRepository extends JpaRepository<ComicPopularityPerDay, Long> {

    List<ComicPopularityPerDay> getComicPopularityPerDaysByDate(LocalDate date, Pageable pageable);

    List<ComicPopularityPerDay> getComicPopularityPerDaysByDateBetween(LocalDate weekStartDate, LocalDate weekEndDate, Pageable pageable);
}
