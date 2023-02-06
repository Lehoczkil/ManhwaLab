package com.codecool.manhwalabbackend.service;

import com.codecool.manhwalabbackend.model.ComicProfile;
import com.codecool.manhwalabbackend.repository.ComicProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ComicProfileService {

    private final ComicProfileRepository comicProfileRepository;

    public ComicProfile getComicProfileByName(String title){
        ComicProfile currentComic = comicProfileRepository.getComicProfileByTitle(title);
        currentComic.setCoverPageSmall(null);
        return currentComic;
    }

    public List<ComicProfile> getAllComic(){
        List<ComicProfile> allComics = comicProfileRepository.findAll();
        for (ComicProfile currentComic : allComics) {
            currentComic.setCoverPageBig(null);
        }
        return allComics;
    }

    public void updateComicViews(Long comicId){
        ComicProfile currentComic = comicProfileRepository.getComicProfileById(comicId);
        Integer currentVies = currentComic.getViews();
        currentComic.setViews(currentVies + 1);
        comicProfileRepository.updateViews(currentVies+1, comicId);
    }

}

