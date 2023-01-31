package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.ComicProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicProfileRepository extends JpaRepository<ComicProfile, Long> {

    ComicProfile getComicProfileByTitle(String title);

    @Query(value = "SELECT rating FROM manhwa_profile " +
            "WHERE manhwa_profile.title LIKE ?1 ORDER BY rating DESC", nativeQuery = true)
    Float getComicProfileRatingByTitle(String title);

    ComicProfile getComicProfileById(Long id);

    @Modifying()
    @Query(value = "UPDATE comic_profile SET views=?1 WHERE id=?2", nativeQuery = true)
    void updateViews(int views, Long comicId);


}

