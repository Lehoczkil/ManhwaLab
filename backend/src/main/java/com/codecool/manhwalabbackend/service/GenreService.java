package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.model.Genre;
import com.codecool.manhwalabbackend.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getComicGenres(int comicId){
        return genreRepository.getComicGenres(comicId);
    }

    public List<Genre> getAllGenre(){
        return genreRepository.findAll();
    }
}
