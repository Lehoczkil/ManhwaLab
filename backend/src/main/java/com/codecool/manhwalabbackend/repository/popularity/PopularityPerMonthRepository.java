package com.codecool.manhwalabbackend.repository.popularity;

import com.codecool.manhwalabbackend.model.popularity.ComicPopularityPerMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PopularityPerMonthRepository extends JpaRepository <ComicPopularityPerMonth, Long> {

    @Modifying
    @Query("UPDATE ComicPopularityPerMonth ppm SET ppm.viewsThisMonth = NULL WHERE ppm.id = :id")
    void nullifyMonthlyViews(@Param("id") Long id);
}
