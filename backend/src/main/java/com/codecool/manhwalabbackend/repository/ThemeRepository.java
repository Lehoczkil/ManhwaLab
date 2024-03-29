package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

    @Query(value = "SELECT theme.id, theme.name FROM theme " +
            "JOIN theme_for_comic tfc on theme.id = tfc.theme_id " +
            "WHERE comic_profile_id = ?1", nativeQuery = true)
    List<Theme> getComicThemes(Long comicId);

}

