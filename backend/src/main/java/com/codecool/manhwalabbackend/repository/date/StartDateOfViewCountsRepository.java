package com.codecool.manhwalabbackend.repository.date;

import com.codecool.manhwalabbackend.model.date.StartDateOfViewCounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StartDateOfViewCountsRepository extends JpaRepository<StartDateOfViewCounts, Long> {

    StartDateOfViewCounts getStartDateOfViewCountsById(Long id);

}
