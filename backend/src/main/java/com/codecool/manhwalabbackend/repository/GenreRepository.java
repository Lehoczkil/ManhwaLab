package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query(value = "SELECT genre.name FROM genre " +
            "JOIN manhwa_profile_genre_list mpgl on genre.id = mpgl.genre_list_id " +
            "WHERE manhwa_profile_id = ?1", nativeQuery = true)
    List<String> getManhwaGenres(int manhwaId);

}

