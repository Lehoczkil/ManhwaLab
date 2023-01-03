package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<String> getManhwaGenres(int manhwaId){
        return genreRepository.getManhwaGenres(manhwaId);
    }

}
