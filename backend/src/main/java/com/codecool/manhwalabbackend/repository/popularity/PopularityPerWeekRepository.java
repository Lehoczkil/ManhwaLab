package com.codecool.manhwalabbackend.repository.popularity;

import com.codecool.manhwalabbackend.model.popularity.PopularityPerWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PopularityPerWeekRepository extends JpaRepository<PopularityPerWeek, Long> {

    @Modifying
    @Query("UPDATE PopularityPerWeek ppw SET ppw.viewsThisWeek = NULL WHERE ppw.id = :id")
    void nullifyWeeklyViews(@Param("id") Long id);
}
