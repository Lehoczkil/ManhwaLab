package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.ComicProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicProfileRepository extends JpaRepository<ComicProfile, Long> {

    ComicProfile getComicProfileByTitle(String title);

    @Query(value = "SELECT rating FROM manhwa_profile " +
            "WHERE manhwa_profile.title LIKE ?1 ORDER BY rating DESC", nativeQuery = true)
    Float getComicProfileRatingByTitle(String title);

    ComicProfile getComicProfileById(Long id);


}

