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
        return comicProfileRepository.getComicProfileByTitle(title);
    }

    public List<ComicProfile> getAllComic(){
        return comicProfileRepository.findAll();
    }

    public void updateComicViews(Long comicId){
        ComicProfile currentComic = comicProfileRepository.getComicProfileById(comicId);
        Integer currentVies = currentComic.getViews();
        currentComic.setViews(currentVies + 1);
        comicProfileRepository.updateViews(currentVies+1, comicId);
    }

    public ComicProfile getComicProfileById(Long comicId){
        return comicProfileRepository.getComicProfileById(comicId);
    }

    public List<ComicProfile> getAllOtherComicProfile(Long comicId){
        List<ComicProfile> allComics = getAllComic();
        allComics.remove(getComicProfileById(comicId));
        return allComics;
    }



}

