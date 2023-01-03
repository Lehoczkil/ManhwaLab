package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.ManhwaProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManhwaProfileRepository extends JpaRepository<ManhwaProfile, Long> {

    ManhwaProfile getManhwaProfileByTitle(String title);

    @Query(value = "SELECT rating FROM manhwa_profile " +
            "WHERE manhwa_profile.title LIKE ?1", nativeQuery = true)
    Float getManhwaProfileRatingByTitle(String title);


}

