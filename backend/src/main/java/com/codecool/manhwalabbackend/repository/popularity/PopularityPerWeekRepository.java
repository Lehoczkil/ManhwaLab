package com.codecool.manhwalabbackend.repository.popularity;

import com.codecool.manhwalabbackend.model.popularity.ComicPopularityPerWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularityPerWeekRepository extends JpaRepository<ComicPopularityPerWeek, Long> {

    @Modifying
    @Query("UPDATE ComicPopularityPerWeek ppw SET ppw.viewsThisWeek = NULL WHERE ppw.id = :id")
    void nullifyWeeklyViews(@Param("id") Long id);
}
