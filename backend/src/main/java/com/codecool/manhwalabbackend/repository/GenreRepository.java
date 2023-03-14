package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query(value = "SELECT genre.id, genre.name FROM genre " +
            "JOIN genre_for_comic gfc on genre.id = gfc.genre_id " +
            "WHERE comic_profile_id = ?1", nativeQuery = true)
    List<Genre> getComicGenres(Long comicId);

}

