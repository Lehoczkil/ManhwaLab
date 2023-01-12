package com.codecool.manhwalabbackend.repository.popularity;

import com.codecool.manhwalabbackend.model.popularity.PopularityPerMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PopularityPerMonthRepository extends JpaRepository <PopularityPerMonth, Long> {

    @Modifying
    @Query("UPDATE PopularityPerMonth ppm SET ppm.viewsThisMonth = NULL WHERE ppm.id = :id")
    void nullifyMonthlyViews(@Param("id") Long id);
}
