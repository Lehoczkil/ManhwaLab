package com.codecool.manhwalabbackend.repository.date;

import com.codecool.manhwalabbackend.model.date.StartDateOfViewCounting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StartDateOfViewCountsRepository extends JpaRepository<StartDateOfViewCounting, Long> {

    StartDateOfViewCounting getStartDateOfViewCountsById(Long id);

}
