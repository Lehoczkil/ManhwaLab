package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.ManhwaProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManhwaProfileRepository extends JpaRepository<ManhwaProfile, Long> {

    ManhwaProfile getManhwaProfileByName(String name);

    @Query(value = "SELECT rating FROM manhwa_profile " +
            "WHERE manhwa_profile.name LIKE ?1", nativeQuery = true)
    Float getManhwaProfileRatingByName(String name);

    @Query(value = "SELECT genre.name FROM genre " +
            "JOIN manhwa_profile_genre_list mpgl on genre.id = mpgl.genre_list_id " +
            "WHERE manhwa_profile_id = ?1", nativeQuery = true)
    List<String> getManhwaGenres(int manhwaId);

}

