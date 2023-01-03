package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.repository.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    ThemeRepository themeRepository;

    @Autowired
    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }


    public List<String> getManhwaThemes(int manhwaId){
        return themeRepository.getManhwaThemes(manhwaId);
    }
}

