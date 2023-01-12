package com.codecool.manhwalabbackend.repository.popularity;

import com.codecool.manhwalabbackend.model.popularity.ComicPopularityPerDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularityPerDayRepository extends JpaRepository<ComicPopularityPerDay, Long> {

    @Modifying
    @Query("UPDATE ComicPopularityPerDay ppd SET ppd.viewsThisDay = NULL WHERE ppd.id = :id")
    void nullifyDailyViews(@Param("id") Long id);
}
