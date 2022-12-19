package com.codecool.manhwalabbackend.repository;

import com.codecool.manhwalabbackend.model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {

}

