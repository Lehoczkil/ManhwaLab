package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.ManhwaProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ManhwaProfileRepository extends JpaRepository<ManhwaProfile, Long> {

    ManhwaProfile getManhwaProfileByName(String name);

    @Query(value = "SELECT rating FROM manhwa_profile " +
            "WHERE manhwa_profile.name LIKE ?1", nativeQuery = true)
    Float getManhwaProfileRatingByName(String name);

}

