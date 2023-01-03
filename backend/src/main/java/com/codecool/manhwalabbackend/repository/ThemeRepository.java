package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

    @Query(value = "SELECT theme.name FROM theme " +
            "JOIN manhwa_profile_theme_list mptl on theme.id = mptl.theme_list_id " +
            "WHERE manhwa_profile_id = ?1", nativeQuery = true)
    List<String> getManhwaThemes(int manwaId);

}

