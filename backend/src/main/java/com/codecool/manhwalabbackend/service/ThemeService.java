package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.model.Theme;
import com.codecool.manhwalabbackend.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    private final ThemeRepository themeRepository;

    @Autowired
    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    public List<Theme> getAllTheme(){
        return themeRepository.findAll();
    }
    public List<Theme> getComicThemes(Long comicId){
        return themeRepository.getComicThemes(comicId);
    }
}

