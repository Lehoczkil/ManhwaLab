package com.codecool.manhwalabbackend.repository.popularity;

import com.codecool.manhwalabbackend.model.popularity.ComicPopularityPerDay;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PopularityRepository extends JpaRepository<ComicPopularityPerDay, Long> {

    List<ComicPopularityPerDay> getComicPopularityPerDaysByDate(LocalDate date, Pageable pageable);

    @Query( value = "SELECT comic_popularity_per_day.comic_id, (array_agg(id))[1] as id, (array_agg(date))[1] as date, SUM(views_this_day) as views_this_day " +
            "FROM comic_popularity_per_day " +
            "WHERE date BETWEEN ?1 AND ?2 " +
            "GROUP BY comic_id " +
            "ORDER BY views_this_day DESC " +
            "LIMIT ?3", nativeQuery = true)
    List<ComicPopularityPerDay> getComicPopularityPerDaysBetweenDates(LocalDate weekStartDate, LocalDate weekEndDate, int limit);
}
